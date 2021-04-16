
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;


public class newStaff {

    static final String ready = "Ready. Message shown";
    static final String pending = "Waiting for input.";
    static final String selected = "Selected. Input given";
    static final String exit = "Finished";
    static State main = new State();

    public static String getMessageOne() {
        String message;
        message = "Welcome staff members\n";
        return message;
    }

    public static String getMessageTwo() {
        String message;
        message = "Here is the current inventory\n";
        return message;
    }

    public static void getStaffMainMenu() {
        System.out.println(getFirstMessageMenu());
        System.out.println(optionOne());
        System.out.println(optionTwo());
        System.out.println(optionThree());
        System.out.println(optionFour());
        System.out.println(optionFive());
    }

    public static String getFirstMessageMenu() {
        return "Please choose an option below ";
    }

    public static String optionOne() {
        return "1 - Add a product ";
    }

    public static String optionTwo() {
        return "2 - Remove a product ";
    }

    public static String optionThree() {
        return "3 - Change stock information of a product ";
    }

    public static String optionFour() {
        return "4 - Apply a discount ";
    }

    public static String optionFive() {
        return "5 - Save changes";
    }

    public static String getStaffInput() {
        return newStore.getInput();
    }

    public static int returnStringToInteger(String input) {
        int output = 0;
        try {
            output = Math.abs(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
        return output;
    }


    private static void exit() {
        System.exit(0);
    }
    /////////////////////ADD PRODUCT///////////////////////////////

    private static String getMessageAddProduct() {
        return "Please add in the following information:\n";
    }

    public static String getMessageAddProductSong() {
        return "Enter song name: ";
    }

    public static String getMessageAddProductArtist() {
        return "Enter artists: ";
    }

    public static String getMessageAddProductPrice() {
        return "Enter the price: ";
    }

    public static String getMessageAddProductStock() {
        return "Enter the stock: ";
    }

    public static float returnStringToFloat(String input) {
        float output = 0;
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        try {
            output = Math.abs(nf.parse(input).floatValue());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static double returnStringToDouble(String input) {
        double output = 0;
        try {
            output = Math.abs(Double.parseDouble(input));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            e.printStackTrace();
        }
        return output;
    }

    public static String staffAddProductSong(String input) {
        return input;
    }

    public static String staffAddProductArtist(String input) {
        return input;
    }

    public static BigDecimal staffAddProductPrice(String input) {
        return new BigDecimal(input);
    }

    public static int staffAddProductStock(String input) {
        return returnStringToInteger(input);
    }

    private static void staffAddProduct(List<Product> list) {

        main.getState();
        System.out.println(getMessageAddProduct());
        main.getState();
        System.out.println(getMessageAddProductSong());

        main.getState();
        final String input = getStaffInput();
        String song = staffAddProductSong(input);
        main.getState();

        main.getState();
        System.out.println(getMessageAddProductArtist());

        main.getState();
        final String inputTwo = getStaffInput();
        main.getState();
        String artists = staffAddProductArtist(inputTwo);

        main.getState();
        System.out.println(getMessageAddProductPrice());

        main.getState();
        final String inputPrice = getStaffInput();
        main.getState();
        BigDecimal price = staffAddProductPrice(inputPrice);

        main.getState();
        System.out.println(getMessageAddProductStock());

        main.getState();
        final String inputStock = getStaffInput();
        main.getState();
        int stock = staffAddProductStock(inputStock);

        Product newProduct = new Product(song, artists, price, stock);
        list.add(newProduct);

        showUpdatedList(list);
        backToMainMenu(list);
    }
    ////////////////////// REMOVE PRODUCT ////////////////////////////

    public static String getMessageRemoveProduct() {
        return "Please enter the product (by index) you would like to remove";
    }

    private static void staffRemoveProduct(List<Product> list) {
        System.out.println(getMessageRemoveProduct());
        final String input = getStaffInput();
        int intItem = returnStringToInteger(input);
        list.remove(intItem);

        showUpdatedList(list);
        backToMainMenu(list);
    }

    /////////////////////CHANGE STOCK////////////////////////////////////
    public static String getMessageChangeStockOne() {
        return "Please enter the product (by index) you would like to change:";
    }

    public static String getMessageChangeStockTwo() {
        return "Please enter the new stock information:";
    }

    public static String getMessageChangeStockThree() {
        return "Updated product information:";
    }

    private static void staffChangeStock(List<Product> list) {

        System.out.println(getMessageChangeStockOne());
        final String input = getStaffInput();
        int intItem = returnStringToInteger(input);

        System.out.println(getMessageChangeStockTwo());
        final String inputTwo = getStaffInput();
        int newStock = returnStringToInteger(inputTwo);

        list.get(intItem).setStock(newStock);
        System.out.println(getMessageChangeStockThree());

        showUpdatedList(list);
        backToMainMenu(list);
    }

    /////////////////////////APPLY DISCOUNT /////////////////////////
    public static String getMessageApplyDiscountOne() {
        return "Please enter the discount you would like to apply: ";
    }

    public static List<Product> getPricesWithDoubleDiscount(double discount, List<Product> list) {
        for (Product product : list) {
            double perDiscount = returnDoubleToPercentage(discount);
            BigDecimal newPrice = product.getPrice().multiply(new BigDecimal(perDiscount));
            product.setPrice(newPrice);
        }
        return list;
    }

    public static double returnDoubleToPercentage(double discount) {
        return (1 - discount / 100.0);
    }

    public static List<Product> getPricesWithIntDiscount(int discount, List<Product> list) {

        for (Product product : list) {
            double perDiscount = returnIntToPercentage(discount);
            BigDecimal newPrice = product.getPrice().multiply(new BigDecimal(perDiscount));
            product.setPrice(newPrice);
        }
        return list;
    }

    public static double returnIntToPercentage(int discount) {
        return (1 - discount / 100.0);
    }

    private static void staffApplyDiscount(List<Product> list) {
        List<Product> newList;

        try {
            System.out.println(getMessageApplyDiscountOne());
            String input = newStore.getInput();
            float number = returnStringToFloat(input); //use float to be used in if integer/else

            if (number % 1 == 0) {
                int discount = returnStringToInteger(input);
                newList = getPricesWithIntDiscount(discount, list);
            } else {
                double discountDouble = returnStringToDouble(input);
                newList = getPricesWithDoubleDiscount(discountDouble, list);
            }
            showUpdatedList(newList);
            backToMainMenu(newList);
        } catch (NumberFormatException e) {
            System.out.println("Input not valid.");
            e.printStackTrace();
        }
    }
    ///////////////////////////BACK TO MAIN MENU///////////////////////////////////////////////////////////////////////

    public static void showUpdatedList(List<Product> list) {
        System.out.println(updatedListMessage());
        newStore.printMenu(list);
    }

    public static String updatedListMessage() {
        return "Here is the updated list\n";
    }

    public static String getMessageBackToMenu() {
        return "\nWould you like to go back to the main menu (Y/N)?";
    }

    public static String getMessageMenuError() {
        return "Please input Y/yes or N/no.";
    }

    public static String getMessageGoodbye() {
        return "Thank you. Goodbye";
    }

    public static void backToMainMenu(List<Product> list) {

        System.out.println(getMessageBackToMenu());

        final String input = getStaffInput();

        returnUserToMenuOrExit(input, list);
    }

    public static void returnUserToMenuOrExit(String input, List<Product> list) {


        if ("Y".equalsIgnoreCase(input)) {
            getStaffMainMenu();
            String newInput = getStaffInput();
            int option = returnStringToInteger(newInput);
            goToSelectedAction(option, list);
        } else if ("Yes".equalsIgnoreCase(input)) {
            getStaffMainMenu();
            String newInputTwo = getStaffInput();
            int optionTwo = returnStringToInteger(newInputTwo);
            goToSelectedAction(optionTwo, list);
        } else if ("No".equalsIgnoreCase(input)) {
            System.out.println(getMessageGoodbye());
        } else if ("N".equalsIgnoreCase(input)) {
            System.out.println(getMessageGoodbye());
        } else {
            System.out.println(getMessageMenuError());
            backToMainMenu(list);
        }
    }

    public static void goToSelectedAction(int option, List<Product> list) {

        // case 5: make method to save changes to json file
        switch (option) {
            case 1 :
                staffAddProduct(list);
            case 2 :
                staffRemoveProduct(list);
            case 3 :
                staffChangeStock(list);
            case 4 :
                staffApplyDiscount(list);
            case 5 :
                exit();
            default : {
                System.out.println("Please enter an option between 1 and 5:");
                String newInput = getStaffInput();
                int newOption = returnStringToInteger(newInput);
                goToSelectedAction(newOption, list);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void runStaff(List<Product> list) {
        String state = ready;
        switch (state) {
            case ready: {
                main.getState();
                System.out.println(getMessageOne());
                System.out.println(getMessageTwo());
                newStore.printMenu(list);
                getStaffMainMenu();
                main.setState(pending);
            }
            case pending: {
                main.getState();
                main.setState(selected);
            }
            case selected: {
                final String input = getStaffInput();
                main.getState();
                int option = returnStringToInteger(input);
                goToSelectedAction(option, list);
                main.getState();
                main.setState(exit);
            }
            case exit: {
                System.out.println("\nStaff status:");
                main.getState();
            }
        }
    }
}


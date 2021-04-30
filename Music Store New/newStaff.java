import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;


public class newStaff {

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

        main.setState(State.ready);
        System.out.println(main.getState());
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
        return "5 - Save changes/ Exit";
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
        main.setState(State.exit);
        System.out.println(main.getState());
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

    public static String staffAddProductSong() {


        String song = "";
        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageAddProduct());
                System.out.println(getMessageAddProductSong());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                song = getStaffInput();
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Adding song state: ");
                System.out.println(main.getState());
                main.setState(State.ready);
                break;
        }
        return song;
    }

    public static String staffAddProductArtist() {

        String artists = "";
        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageAddProductArtist());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                artists = getStaffInput();
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Adding artists state: ");
                System.out.println(main.getState());
                main.setState(State.ready);
                break;
        }
        return artists;
    }

    public static BigDecimal staffAddProductPrice() {

        BigDecimal price = null;
        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageAddProductPrice());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                String input = getStaffInput();
                price = new BigDecimal(input);
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Adding price state: ");
                System.out.println(main.getState());
                main.setState(State.ready);
                break;
        }
        return price;
    }

    public static int staffAddProductStock() {

        int stock = 0;
        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageAddProductStock());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                String input = newStore.getInput();
                stock = returnStringToInteger(input);
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Adding stock state: ");
                System.out.println(main.getState());
                main.setState(State.ready);
                break;
        }
        return stock;
    }

    private static void staffAddProduct(List<Product> list) {

        String song = "";
        String artists = "";
        BigDecimal price = null;
        int stock = 0;
        if (State.ready.equals(main.getState())) {
            song = staffAddProductSong();
            artists = staffAddProductArtist();
            price = staffAddProductPrice();
            stock = staffAddProductStock();
            main.setState(State.exit);
        }

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

        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageRemoveProduct());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                final String input = getStaffInput();
                int intItem = returnStringToInteger(input);
                list.remove(intItem);
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Removing product state: ");
                System.out.println(main.getState());
                break;
        }

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


    private static void staffChangeStock(List<Product> list) {

        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageChangeStockOne());
                System.out.println(getMessageChangeStockTwo());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                final String input = getStaffInput();
                int intItem = returnStringToInteger(input);
                final String inputTwo = getStaffInput();
                int newStock = returnStringToInteger(inputTwo);
                list.get(intItem).setStock(newStock);
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Changing stock state: ");
                System.out.println(main.getState());
                break;
        }

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

        List<Product> newList = null;
        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageApplyDiscountOne());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                String input = newStore.getInput();
                float number = returnStringToFloat(input);
                if (number % 1 == 0) {
                    int discount = returnStringToInteger(input);
                    newList = getPricesWithIntDiscount(discount, list);
                } else {
                    double discountDouble = returnStringToDouble(input);
                    newList = getPricesWithDoubleDiscount(discountDouble, list);
                }
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println("Adding song state: ");
                System.out.println(main.getState());
                break;
        }
        showUpdatedList(newList);
        backToMainMenu(newList);

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

        switch(main.getState()) {
            case State.ready:
                main.setState(State.ready);
                System.out.println(main.getState());
                System.out.println(getMessageBackToMenu());
                main.setState(State.pending);
                break;

            case State.pending:
                System.out.println(main.getState());
                final String input = getStaffInput();
                returnUserToMenuOrExit(input, list);
                main.setState(State.selected);
                break;

            case State.selected:
                System.out.println(main.getState());
                main.setState(State.exit);
                break;

            case State.exit:
                System.out.println(main.getState());
                break;
        }
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
                main.setState(State.exit);
                System.out.println(State.exit);
            default : {
                System.out.println("Please enter an option between 1 and 5:");
                String newInput = getStaffInput();
                int newOption = returnStringToInteger(newInput);
                goToSelectedAction(newOption, list);
            }
        }
    }

    public static boolean hasFinished() {
        if (main.getState().equals(State.exit)) {
            System.out.println("\nStaff status:");
            System.out.println(main.getState());
            return true;
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void runStaff(List<Product> list) {
        do {
            switch (main.getState()) {
                case State.ready: {
                    main.setState(State.ready);
                    System.out.println(main.getState());
                    System.out.println(getMessageOne());
                    System.out.println(getMessageTwo());
                    newStore.printMenu(list);
                    getStaffMainMenu();
                    main.setState(State.pending);
                    break;
                }
                case State.pending: {
                    System.out.println(main.getState());
                    final String input = getStaffInput();
                    int option = returnStringToInteger(input);
                    main.setState(State.selected);
                    goToSelectedAction(option, list);
                    break;
                }
                case State.selected: {
                    System.out.println(main.getState());
                    main.setState(State.ready);
                    break;
                }
            }
        } while (!hasFinished());

    }
}


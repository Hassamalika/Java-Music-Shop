import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;


public class newStore {

    static State menu = new State();


    public static String getMessageTwo(BigDecimal price) {
        return "\nThat will be £ " + price + ". \n \nPlease input how much you would like to give me:";
    }

    public static void printHeader() {
        System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
        System.out.println("\nPlease input which CD you would like:");
    }

    public static void printMenu(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + list.get(i).getMessage());
        }
    }

    public static String getInput() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputOne = null;

        try {
            System.out.println("> ");
            inputOne = reader.readLine();
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return inputOne;

    }

    public static BigDecimal displayPrice(int choice, List<Product> list) {
        return list.get(choice).getPrice();
    }


    public static boolean hasFinished() {
        if (menu.getState().equals(State.exit)) {
            System.out.println("\nStore status:");
            System.out.println(menu.getState());
            return true;
        }
        return false;
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static int returnUserSelection(String userInput, List<Product> list) {
        int choice = returnChoiceAsInteger(userInput);
        BigDecimal price = displayPrice(choice, list);

        if (userInput.length() > 1) {
            menu.message = "Please enter a number between 0 and 3.";
        } else if (choice >= 4) {
            menu.message = "Please enter a number between 0 and 3.";
        } else {
            menu.message = getMessageTwo(price);
        }
        return choice;
    }

    public static String calculateChange(BigDecimal amount, BigDecimal price) {
        BigDecimal change = null;
        String message;
        if (amount.compareTo(price) > 0) {
            change = amount.subtract(price);
            message = "\nThank you. Your change is £" + change + ".";
        } else {
            message = "Invalid amount. Amount must be greater than price.";
        }
        return message;
    }

    public static String returnUserChange(String userInput, int choice, List<Product> list) {
        BigDecimal amount = new BigDecimal(userInput);
        String message;
        if (amount.stripTrailingZeros().scale() <= 0) {
            BigDecimal price = displayPrice(choice, list);
            message = calculateChange(amount, price);
        } else {
            message = "Please enter a numeric amount greater than the price.";
        }
        return message;
    }


    public String customerStore(List<Product> list) {
        String userChoice = "";
        int choice = 0;
        switch (menu.getState()) {
            case State.ready:
                menu.setState(State.ready);
                printHeader();
                printMenu(list);
                menu.setState(State.pendingChoice);
                break;

            case State.pendingChoice:
                userChoice = getInput();
                choice = returnUserSelection(userChoice, list);
                menu.setState(State.pendingAmount);
                break;

            case State.pendingAmount:
                userChoice = getInput();
                menu.message = returnUserChange(userChoice, choice, list);
                break;

            case State.exit:
                break;

        }
        return menu.getState();
    }


    public void runStore(List<Product> list) {
        do {
            print(customerStore(list));
        } while (!hasFinished());
    }

    public static int returnChoiceAsInteger(String userChoice) {
        int choice = 0;
        String message;
        if (userChoice.length() > 1) {
            message = "Please enter a number between 0 and 3.";
        } else {
            choice = Math.abs(Integer.parseInt(userChoice));
            if (choice >= 4) {
                message = "Please enter a number between 0 and 3.";
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        newStore p = new newStore();
        List<Product> list = Product.loadProductsJson();
        p.runStore(list);
    }
}

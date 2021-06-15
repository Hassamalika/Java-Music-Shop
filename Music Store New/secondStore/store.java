package secondStore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class store {

    static State state = new State();

    public static String message;


    public static void printMenuList(List<Product> list) {
        System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + list.get(i).getMessage());
        }
        System.out.println("\nPlease input which CD you would like:");
    }

    public static int returnChoiceInteger(String userInput) {
        return Math.abs(Integer.parseInt(userInput));
    }

    public static String returnUserSelection(BigDecimal price) {
        message = "\nThat will be £" + price + ". \n \nPlease input how much you would like to give me:";
        return message;
    }

    public static BigDecimal displayPrice(int choice, List<Product> list) {
        BigDecimal price = null;
        if (choice <= 3) {
            price = list.get(choice).getPrice();
        } else {
            state.setState(State.error);
        }
        return price;
    }

    public static String returnUserChange(BigDecimal amount, BigDecimal price) {
        if (amount.compareTo(price) > 0) {
            BigDecimal change = amount.subtract(price);
            message = "\nThank you. Your change is £" + change + ".";
            state.setState(State.exit);
        } else {
            message = "Invalid amount. Amount must be greater than price.";
            state.setState(State.error);
        }

        return message;
    }

    public static boolean hasFinished() {
        if (state.getState().equals(State.exit)) {
            System.out.println("\nStore status:");
            System.out.println(state.getState());
            return true;
        }
        return false;
    }

    public static boolean validateFirstInput(String input) {
        int choice = returnChoiceInteger(input);
        return (!(input.length() > 1)) & (choice <= 3);

    }

    public static boolean ifNumber(String input) {
        if (input.length() > 2) {
            state.setState(State.error);
            return false;
        }
        return true;
    }

    public static boolean ifChoiceInList(String input) {
        int choice = returnChoiceInteger(input);
        if (choice <= 3) {
            return true;
        }
        state.setState(State.error);
        return false;
    }

    public static int getChoicePrice(String input) {
        int choice = 0;
        if (ifNumber(input) & ifChoiceInList(input)) {
            choice = returnChoiceInteger(input);
        }
        return choice;
    }

    public static String userInputTwo(String input, List<Product> list) {
        state.setState(State.pendingChoice);
        message = state.getState();
        int choice = returnChoiceInteger(input);
        BigDecimal amount = new BigDecimal(input).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal price = displayPrice(choice, list);
        if (amount.compareTo(price) < 0) {
            message = returnUserSelection(price);
            state.setState(State.pendingAmount);
        } else if (amount.compareTo(price) > 0){
            message = returnUserChange(amount, price);
            state.setState(State.exit);
        }
        return message;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;


public class newStore {

    static State menu = new State();

    public static String getMessageOne() {
        return "\nPlease input which CD you would like:";
    }

    public static String getMessageTwo(BigDecimal price) {
        return "\nThat will be £ " + price + ".";
    }

    public static String getMessageThree() {
        return "\nPlease input how much you would like to give me:";
    }

    public static String getMessageFour(BigDecimal change) {
        return "\nThank you. Your change is £" + change + ".";
    }

    public static void printHeader() {
        System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
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

    public static int returnChoiceAsInteger(String input, List<Product> list) {
        float a = 0;
        try{
            a = Math.abs(Float.parseFloat(input));
        } catch(NumberFormatException e){
            System.out.println("Invalid input. Must be a number.");
            final String reChoice = getInput();
            runMenu(reChoice, list);
        }
        return Math.round(a);
    }

    public static String getNoChangeMessage() {
        return "\nPlease input an amount greater than the price";
    }

    public static BigDecimal calculateChange(BigDecimal amount, BigDecimal price) {
        return amount.subtract(price);
    }

    public static BigDecimal getAmount(String input) {
        return new BigDecimal(input);
    }

    public static void getUserSecondAmount(BigDecimal price) {
        System.out.println(getNoChangeMessage());
        System.out.println(getMessageThree());
        final String input = getInput();
        BigDecimal newAmount = getAmount(input);
        BigDecimal newChange = calculateChange(newAmount, price);
        System.out.println(getMessageFour(newChange));
    }

    public static void showUserChange(BigDecimal price, BigDecimal amount, BigDecimal change) {
        int res = amount.compareTo(price);

        if (res < 0) {
            getUserSecondAmount(price);
        } else {
            System.out.println(getMessageFour(change));
        }

    }

    static void runChange(BigDecimal price) {
        menu.setState(State.pending);
        System.out.println(menu.getState());
        final String input = getInput();
        BigDecimal amount = getAmount(input);
        BigDecimal change = calculateChange(amount, price);
        showUserChange(price, amount, change);

        menu.setState(State.selected);
        System.out.println(menu.getState());
        menu.setState(State.ready);
        System.out.println(menu.getState());
    }

    static void runMenu(String input, List<Product> list) {
        System.out.println(menu.getState());
        int choice = returnChoiceAsInteger(input, list);
        try {
            BigDecimal price = displayPrice(choice, list);
            System.out.println(getMessageTwo(price));
            System.out.println(getMessageThree());
            runChange(price);

        } catch (IndexOutOfBoundsException e) {
            menu.setState(State.ready);
            System.out.println(menu.getState());
            String message = "Please enter a number between 0 and 3.";
            System.out.println(message);
            System.out.println(getMessageOne());
            final String rePrompt = getInput();
            runMenu(rePrompt, list);
        } catch (NumberFormatException e){
            System.out.println("Invalid input");
        }
    }


    public static boolean hasFinished() {
        if (menu.getState().equals(State.exit)) {
            System.out.println("\nStore status:");
            System.out.println(menu.getState());
            return true;
        }
        return false;
    }

    public static void runStore(List<Product> list) {
        do {
            switch (menu.getState()) {
                case State.ready -> {
                    menu.setState(State.ready);
                    System.out.println(menu.getState());
                    printHeader();
                    printMenu(list);
                    System.out.println(getMessageOne());
                    menu.setState(State.pending);
                }
                case State.pending -> {
                    System.out.println(menu.getState());
                    menu.setState(State.selected);
                }
                case State.selected -> {
                    final String userChoice = getInput();
                    runMenu(userChoice, list);
                    menu.setState(State.exit);
                }
                case State.exit -> {
                    System.out.println("Store status: ");
                    System.out.println(menu.getState());
                }
            }
        } while (!hasFinished());

    }
}

// keep testing loop, does not exit.


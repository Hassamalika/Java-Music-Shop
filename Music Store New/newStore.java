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

    public static String getNoChangeMessage() {
        return "\nPlease input an amount greater than the price";
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

    public static BigDecimal calculateChange(BigDecimal amount, BigDecimal price) {
        return amount.subtract(price);
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

    public static void runStore(List<Product> list) {
        BigDecimal price = null;
        String userChoice;
        do {
            switch (menu.getState()) {
                case State.ready:
                    printHeader();
                    printMenu(list);
                    print(getMessageOne());
                    menu.setState(State.pending);
                    break;

                case State.pending:
                    //take input
                    //Either move to next state if correct
                    // Or raise error and validate, loop again
                    while (true) {
                        userChoice = getInput();
                        if (userChoice.length() > 1) {
                            menu.setState(State.error);
                        }
                        else {
                            int choice = returnChoiceAsInteger(userChoice);
                            if (choice >= 4) {
                                menu.setState(State.error);
                            } else {
                                price = displayPrice(choice, list);
                                print(getMessageTwo(price));
                                print(getMessageThree());
                                menu.setState(State.selected);
                            }
                        }
                        break;
                    }
                    break;

                case State.error:
                    String message = "Please enter a number between 0 and 3.";
                    print(message);
                    menu.setState(State.pending);
                    break;

                case State.selected:
                    userChoice = getInput();
                    BigDecimal amount = new BigDecimal(userChoice);
                    BigDecimal change = calculateChange(amount, price);
                    while (true) {
                        int res = amount.compareTo(price);
                        if (res > 0) {
                            print(getMessageFour(change));
                            menu.setState(State.exit);
                        } else {
                            menu.setState(State.selected);
                        }
                        break;
                    }
                    break;

                case State.exit:
                    System.out.println(menu.getState());
                    break;
            }
        } while (!hasFinished());
    }

    public static int returnChoiceAsInteger(String userChoice) {
        return Math.abs(Integer.parseInt(userChoice));
    }
}


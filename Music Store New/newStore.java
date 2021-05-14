import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;


public class newStore {

    static Store st = new Store();
    static State menu = new State();

    public String getMessageOne() {
        return "\nPlease input which CD you would like:";
    }

    public String getMessageTwo(BigDecimal price) {
        return "\nThat will be £ " + price + ".";
    }

    public String getMessageThree() {
        return "\nPlease input how much you would like to give me:";
    }

    public String getMessageFour(BigDecimal change) {
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

    public String customerStore(List<Product> list) {
        String userChoice;
        BigDecimal price = null;
        print(menu.getState());
        switch (menu.getState()) {
            case State.ready:
                menu.setState(State.ready);
                printHeader();
                printMenu(list);
                st.message = getMessageOne();
                menu.setState(State.pendingChoice);
                break;

            case State.pendingChoice:
                //take input
                //Either move to next state if correct
                // Or raise error and validate, loop again
                userChoice = getInput();
                int choice = returnChoiceAsInteger(userChoice);
                if (userChoice.length() > 1) {
                    st.message = "Please enter a number between 0 and 3.";
                } else if (choice >= 4) {
                    st.message = "Please enter a number between 0 and 3.";
                } else {
                    price = displayPrice(choice, list);
                    st.message = getMessageTwo(price);
                    menu.setState(State.pendingAmount);
                }
                break;

            case State.pendingAmount:
                st.message = getMessageThree();
                userChoice = getInput();
                if (userChoice.length() > 1) {
                    st.message = "Insufficient amount given. Please enter a numeric amount greater than the price.";
                } else {
                    BigDecimal amount = new BigDecimal(userChoice);
                    BigDecimal change = calculateChange(amount, price);
                    int res = amount.compareTo(price);
                    if (res > 0) {
                        st.message = getMessageFour(change);
                        menu.setState(State.exit);
                    } else {
                        st.message = "Insufficient amount given. Please enter a numeric amount greater than the price.";
                    }
                }

                break;

            case State.exit:
                System.out.println(menu.getState());
                break;
        }
        return st.getMessage();
    }


    public void runStore(List<Product> list) {
        do {
            print(customerStore(list));
        } while (!hasFinished());
    }

    public static int returnChoiceAsInteger(String userChoice) {
        return Math.abs(Integer.parseInt(userChoice));
    }

    public static void main(String[] args) {
        newStore p = new newStore();
        List<Product> list = Product.loadProductsJson();
        p.runStore(list);
    }
}


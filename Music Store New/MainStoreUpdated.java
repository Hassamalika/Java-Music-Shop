import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainStoreUpdated {

    static State main = new State();

    public static List<Product> list = new ArrayList<>();

    public static String getCurrentMessage() {
        return "Hello, if you are a ...\n";
    }

    public static String getMessageForCustomer() {
        return "a customer, press 1\n";
    }

    public static String getMessageForStaff() {
        return "a staff member, press 2\n";
    }

    public static void userInput(String input) {
        list = Product.loadProductsJson();

        if (Objects.equals(input, "1")) {
            newStore.runStore(list);
        } else if (Objects.equals(input, "2")) {
            newStaff.runStaff(list);
        } else {
            System.out.println("PLease enter either 1 or 2");
            String newInput = newStore.getInput();
            userInput(newInput);
        }
    }

    public static boolean hasFinished() {
        if (State.exit.equals(State.exit)) {
            System.out.println("\nMain Store status:");
            main.getState();
        }
        return true;
    }


    public static void main(String[] args) {
        do {
            switch (State.ready) {
                case State.ready: {
                    main.setState(State.ready);
                    main.getState();
                    System.out.println(getCurrentMessage());
                    System.out.println(getMessageForCustomer());
                    System.out.println(getMessageForStaff());
                    main.setState(State.pending);
                }
                case State.pending: {
                    main.getState();
                    main.setState(State.selected);
                }
                case State.selected: {
                    final String userInput = newStore.getInput();
                    main.getState();
                    userInput(userInput);
                    main.setState(State.exit);
                }
            }
        } while (!hasFinished());

    }
}

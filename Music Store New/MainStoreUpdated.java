

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
//            newStoreUpdate.main(list);
        } else if (Objects.equals(input, "2")) {
            newStaff.runStaff(list);
        } else {
            System.out.println("PLease enter either 1 or 2");
            String newInput = newStore.getInput();
            userInput(newInput);
        }
    }

    public static boolean hasFinished() {
        if (main.getState().equals(State.exit)) {
            System.out.println("\nMain Store status:");
            System.out.println(main.getState());
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        do {
            switch (main.getCurrentMessage()) {
                case State.ready: {
                    main.setState(State.ready);
                    System.out.println(main.getState());
                    System.out.println(getCurrentMessage());
                    System.out.println(getMessageForCustomer());
                    System.out.println(getMessageForStaff());
                    main.setState(State.pendingChoice);
                    break;
                }
                case State.pendingChoice: {
                    System.out.println(main.getState());
                    main.setState(State.selected);
                    break;
                }
                case State.selected: {
                    final String userInput = newStore.getInput();
                    System.out.println(main.getState());
                    userInput(userInput);
                    main.setState(State.exit);
                    break;
                }
            }
        } while (!hasFinished());

    }
}



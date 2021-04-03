package hmalika;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainStoreUpdated {

    public static List<Product> list = new ArrayList<>();

    public static String getCurrentMessage() { return "Hello, if you are a ...\n"; }

    public static String getMessageForCustomer() {
        return "a customer, press 1\n";
    }

    public static String getMessageForStaff() {
        return "a staff member, press 2\n";
    }

    public static void userInput(String input) {
        list = Product.loadProductsJson();

        if(Objects.equals(input, "1")){
            NewStore.runStore(list);
        } else if(Objects.equals(input, "2")){
            NewStaff.runStaff(list);
        }else{
            System.out.println("PLease enter either 1 or 2");
            String newInput = NewStore.getInput();
            userInput(newInput);
        }
    }

    public static boolean hasFinished() {
        return true;
    }


    public static void main(String[] args) {
        do {
            try {
                System.out.println(getCurrentMessage());
                System.out.println(getMessageForCustomer());
                System.out.println(getMessageForStaff());
                final String userInput = NewStore.getInput();
                userInput(userInput);
            } catch(NumberFormatException e) {
                System.out.println("Please enter an option.");
                final String userInputTwo = NewStore.getInput();
                userInput(userInputTwo);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a choice from the menu.");
                final String userInputThree = NewStore.getInput();
                userInput(userInputThree);
            }
        } while (!hasFinished());
    }
}

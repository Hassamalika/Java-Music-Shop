package hmalika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class NewStore {

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
        return "\nThank you. Your change is £" + change;
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
            inputOne = reader.readLine();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return inputOne;

    }

    public static BigDecimal displayPrice(String input, List<Product> list) {
        int userChoice = returnChoiceAsInteger(input);
        return list.get(userChoice).getPrice();
    }

    public static int returnChoiceAsInteger(String input) {
        float a = Math.abs(Float.parseFloat(input));
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

    public static boolean hasFinished() {
        return true;
    }

    public static void showUserChange(BigDecimal amount, BigDecimal price, BigDecimal change) {
        if (amount.compareTo(price) > 0) {
            System.out.println(getMessageFour(change));
        } else {
            System.out.println(getNoChangeMessage());
            System.out.println(getMessageThree());
            String newInput = getInput();
            BigDecimal newAmount = getAmount(newInput);
            BigDecimal newChange = calculateChange(newAmount, price);
            System.out.println(getMessageFour(newChange));
        }
    }

    public static void runMenu(List<Product> list, String input) {
        BigDecimal price = displayPrice(input, list);
        System.out.println(getMessageTwo(price));
        System.out.println(getMessageThree());
        final String userAmount = getInput();
        BigDecimal amount = getAmount(userAmount);
        BigDecimal change = calculateChange(amount, price);
        showUserChange(amount, price, change);
    }

    public static void runStore(List<Product> list) {
        do {
            try {
                printHeader();
                printMenu(list);
                System.out.println(getMessageOne());
                final String userChoice = getInput();
                runMenu(list, userChoice);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a choice from the menu.");
                final String userChoiceTwo = getInput();
                runMenu(list, userChoiceTwo);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                final String userChoiceThree = getInput();
                runMenu(list, userChoiceThree);
            } catch (Exception e) {
                System.out.println("Some other exception has occurred.");
            }
        }
        while (!hasFinished());
    }

}



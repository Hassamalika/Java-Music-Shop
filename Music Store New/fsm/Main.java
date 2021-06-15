package fsm;

import secondStore.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Product> list = new ArrayList<>();

    public static void main(String[] args) {
//        list = Product.loadProductsJson();
//        store.printMenuList(list);
        Store store = new Store();

        do {
            System.out.println(store.getMessage());
            final String inputOne = getInput();
            System.out.println(store.userInput(inputOne));
            // System.out.println(store.getMessage());
        } while (!store.hasFinished());
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
}

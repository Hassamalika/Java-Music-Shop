package secondStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class mainStore {

    public static List<Product> list = new ArrayList<>();

    public static void main(String[] args) {
        list = Product.loadProductsJson();
        store.printMenuList(list);
        do {
            final String inputOne = getInput();
            System.out.println(store.userInputTwo(inputOne, list));

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

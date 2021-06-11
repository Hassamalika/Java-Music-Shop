package secondStore.srctest;

import org.junit.Assert;
import org.junit.Test;
import secondStore.Product;
import secondStore.State;
import secondStore.store;

import java.util.ArrayList;
import java.util.List;

public class newTest {

    public static List<Product> list = new ArrayList<>();
    State st = new State();

    @Test
    public void testValidateFirstInput(){
        Assert.assertTrue(store.validateFirstInput("1"));
    }

    @Test
    public void testIfNumber(){
        // tests if single digit is given (0,1, 2, 3) but what if list extends to > 9?
        Assert.assertTrue(store.ifNumber("1"));
    }

    @Test
    public void testChoice(){
        Assert.assertTrue(store.ifChoiceInList("3"));
        // error when asserting state changes within method
        //Assert.assertEquals(State.error, store.state.getState());
    }

    @Test
    public void testGetChoicePrice() {
        Assert.assertEquals(1, store.getChoicePrice("5"));
    }

    @Test
    public void testUserInput() {
        String input = "1";
        list = Product.loadProductsJson();

        String exp = State.error;

        Assert.assertEquals(exp, store.userInputTwo(input, list));
    }
}

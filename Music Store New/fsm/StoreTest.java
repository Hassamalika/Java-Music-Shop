package fsm;

import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    @Test
    public void test() {
        Store store = new Store();
        //String expected = "Hello, welcome to my shop. \n 1. CD1 - Artist - £1.50 \n 2. CD2 - Artist2 - £5.00 \n";
        Assert.assertEquals("Hello, welcome to my shop. \n 1. CD1 - Artist - £1.50 \n 2. CD2 - Artist2 - £5.00 \n", store.getMessage());

        Assert.assertFalse(store.isNumeric("one"));

        Assert.assertEquals(store.error, store.userInput("one"));
        //test passes for non numeric input

        // Assert.assertFalse(store.ifError());

        Assert.assertEquals(store.error, store.getMessage());

        Assert.assertEquals("Please pay £5.0.", store.getMessage());

        Assert.assertNull(store.userInput("6"));

        Assert.assertEquals("Thank you, your change is £1.0", store.getMessage());

        Assert.assertTrue(store.hasFinished());
    }
}

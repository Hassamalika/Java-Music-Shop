package fsm;

import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    Store store = new Store();

    @Test
    public void testHappyPath() {
        Store store = new Store();
        //String expected = "Hello, welcome to my shop. \n 1. CD1 - Artist - £1.50 \n 2. CD2 - Artist2 - £5.00 \n";
        Assert.assertEquals("Hello, welcome to my shop. \n 1. CD1 - Artist - £1.50 \n 2. CD2 - Artist2 - £5.00 \n", store.getMessage());

        Assert.assertNull(store.userInput("2"));

        Assert.assertEquals("Please pay £5.0.", store.getMessage());

        Assert.assertNull(store.userInput("6"));

        Assert.assertEquals("Thank you, your change is £1.0", store.getMessage());

        Assert.assertTrue(store.hasFinished());
    }

    @Test
    public void testChoiceOutOfRange() {

        Assert.assertEquals("Please enter between 1 and 2", store.userInput("4"));

    }

    @Test
    public void testChoiceIfNotInteger() {
        Assert.assertEquals("Please enter a numeric choice from list", store.userInput("one"));
    }

    @Test
    public void testChoiceZero() {

        Assert.assertEquals("Please enter between 1 and 2", store.userInput("0"));

    }

    @Test
    public void testAmountIsNumber(){
        store.userInput("2");
        Assert.assertEquals("Please enter a numeric amount", store.userInput("six"));
    }

    @Test
    public void testAmountIsPositive(){
        store.userInput("2");
        Assert.assertEquals("Please enter an amount greater than the price", store.userInput("-6"));
    }

    @Test
    public void testAmountIsGreaterThanPrice(){
        store.userInput("2");
        Assert.assertEquals("Please enter an amount greater than the price", store.userInput("3"));
    }

}

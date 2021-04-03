package hmalika;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NewStoreTest {

    @Test
    public void testFirstMessages() {
        Assert.assertTrue(MainStoreUpdated.getCurrentMessage().contains("Hello, if you are a ..."));
        Assert.assertTrue(MainStoreUpdated.getMessageForCustomer().contains("a customer, press 1"));
        Assert.assertTrue(MainStoreUpdated.getMessageForStaff().contains("a staff member, press 2"));
    }

    @Test
    public void testMainToStore() {
        Assert.assertTrue(NewStore.getMessageOne().contains("Please input which CD you would like:"));
    }

    @Test
    public void testNewStoreNextMessage() {
        String price = "3.50";
        Assert.assertTrue(NewStore.getMessageTwo(new BigDecimal(price)).contains("That will be £ 3.50."));

        Assert.assertTrue(NewStore.getMessageThree().contains("Please input how much you would like to give me"));
    }

    @Test
    public void testNewStoreAmount() {

        String input = "5";

        BigDecimal expected = new BigDecimal(input);

        Assert.assertEquals(expected, NewStore.getAmount(input));
    }

    @Test
    public void testNewStoreChange() {
        BigDecimal amount = new BigDecimal("5");
        BigDecimal price = new BigDecimal("3.50");
        BigDecimal change = new BigDecimal("1.50");
        Assert.assertEquals(change, NewStore.calculateChange(amount, price));

        Assert.assertTrue(NewStore.getMessageFour(NewStore.calculateChange(amount, price)).contains("Thank you. Your change is £1.50"));

        NewStore.showUserChange(amount, price, change);

        Assert.assertTrue(NewStore.hasFinished());
    }



}

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    public static List<Product> list = new ArrayList<>();

    @Test
    public  void testGetChange() {
        list = Product.loadProductsJson();
        int choice = 0;
        String userAmount = "2";

        BigDecimal price = newStore.displayPrice(choice, list);
        BigDecimal amount = new BigDecimal(userAmount);
        String change = newStore.calculateChange(amount, price);

        //Assert.assertTrue(change.contains("\nThank you. Your change is £1.50."));
        Assert.assertTrue(change.contains("Invalid amount. Amount must be greater than price."));

    }
    ///////////////////////////////////////////////////////////////////////////////
    @Test
    public void testDisplayPrice() {
        list = Product.loadProductsJson();
        int choice = 1;

        BigDecimal expected = new BigDecimal(13.50).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal actual = new BigDecimal(String.valueOf(newStoreUpdate.displayPrice(choice, list)));

        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void testReturnChange() {
//        String input = "1";
//        int choice = 0;
//        list = Product.loadProductsJson();
//        // Assert.assertTrue(newStoreUpdate.returnUserChange(input, choice, list).contains("Please enter a numeric amount greater than the price."));
//        //Assert.assertEquals("Invalid amount. Amount must be greater than price.", newStoreUpdate.returnUserChange(input, choice, list));
//    }

    @Test
    public void testCustomerStore() {
        list = Product.loadProductsJson();

        String inputOne = "0";
        String inputTwo = "5";

        newStoreUpdate s = new newStoreUpdate();

        Assert.assertEquals(State.ready, newStoreUpdate.menu.getState());
        Assert.assertEquals(State.pendingChoice, newStoreUpdate.customerStore(list, inputOne, inputTwo));

    }








}

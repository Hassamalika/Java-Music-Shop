import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    public static List<Product> list = new ArrayList<>();

//    @Test
//    public void testDisplayPrice() {
//        list = Product.loadProductsJson();
//
//        String input = "5";
//        BigDecimal expected = new BigDecimal(3.50);
//        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
//        BigDecimal actual = newStore.displayPrice(input, list);
//
//        Assert.assertEquals(expected, actual);
//    }

//    @Test
//    public  void testGetChange() {
//        list = Product.loadProductsJson();
//        String choice = "0";
//        String userAmount = "5";
//
//        BigDecimal price = newStore.displayPrice(choice, list);
//        BigDecimal amount = newStore.getAmount(userAmount);
//        BigDecimal change = newStore.calculateChange(amount, price);
//
//        Assert.assertTrue(newStore.getMessageFour(change).contains("\nThank you. Your change is £" + change + "."));
//    }

//    @Test
//    public void testRunMenu() {
//        String testInput = "0";
//        list = Product.loadProductsJson();
//        BigDecimal test = new BigDecimal(3.50);
//        test = test.setScale(2, RoundingMode.HALF_EVEN);
//
//        Assert.assertEquals(test, newStore.displayPrice(testInput, list));
//        Assert.assertTrue(newStore.getMessageTwo(test).contains("\nThat will be £ " + test + "."));
//    }

    @Test
    public void testRunChange() {
        list = Product.loadProductsJson();
        String test = "five";
        BigDecimal testPrice = new BigDecimal("13.50");
        BigDecimal testAmount =new BigDecimal(test);

        // Assert.assertEquals(new BigDecimal(5.50).setScale(2, RoundingMode.HALF_EVEN), testAmount);
        // Assert.assertTrue(newStore.calculateChange(testAmount, testPrice).contains("Invalid amount. Amount must be greater than price."));

        //Assert.assertTrue(newStore.calculateChange(testAmount, testPrice).contains("\nThank you. Your change is £6.50."));

        Assert.assertTrue(newStore.returnUserChange(test, 0, list).contains("Please enter a numeric amount greater than the price."));
    }

//    @Test
//    public void testRunStore(){
//
//        newStore s = new newStore();
////        s.getMessage();
////        s.getCurrentState();
////        s.setInitialState();
//
//    }

}

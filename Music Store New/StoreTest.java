import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    public static List<Product> list = new ArrayList<>();
    static State test = new State();

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
        String test = "2.50";
        BigDecimal testPrice = new BigDecimal(3.50);
        BigDecimal testAmount = newStore.getAmount(test);
        BigDecimal testChange = newStore.calculateChange(testAmount, testPrice);

        // Assert.assertEquals(new BigDecimal(5.50).setScale(2, RoundingMode.HALF_EVEN), testAmount);
        Assert.assertEquals(new BigDecimal(2.00).setScale(2, RoundingMode.HALF_EVEN), testChange);
    }

}

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    public static List<Product> list = new ArrayList<>();
    static State test = new State();

    @Test
    public void testDisplayPrice() {
        list = Product.loadProductsJson();

        String input = "5";
        BigDecimal expected = new BigDecimal(3.50);
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal actual = newStore.displayPrice(input, list);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public  void testGetChange() {
        list = Product.loadProductsJson();
        String choice = "0";
        String userAmount = "5";

        BigDecimal price = newStore.displayPrice(choice, list);
        BigDecimal amount = newStore.getAmount(userAmount);
        BigDecimal change = newStore.calculateChange(amount, price);

        Assert.assertTrue(newStore.getMessageFour(change).contains("\nThank you. Your change is £" + change + "."));
    }


}

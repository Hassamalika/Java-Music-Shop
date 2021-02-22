import org.junit.Assert;
import org.junit.Test;

public class MusicTest {

    @Test
    public void shouldReturnTheCorrectPrice()
    {
        final Music music = new Music("song", "artist", 1.0);

        final double expectedPrice = 1.0;
        final double actualPrice = music.returnPrice();

        final int toleratedDifference = 0;

        Assert.assertEquals(expectedPrice, actualPrice, toleratedDifference);
    }

}
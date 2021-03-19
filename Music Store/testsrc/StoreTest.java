
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import hmalika.Music;
import hmalika.Product;
import hmalika.Store;
import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class StoreTest {
	

	@Test
	public void testGetPrice() {
		final Music music = new Music("song", "artist", 100);

		final double expectedPrice = 100;
		final double actualPrice = music.getPrice();
		final int toleratedDifference = 0;
		Assert.assertEquals(expectedPrice, actualPrice, toleratedDifference);
		
	}
	
	@Test
	public void testGetChoice() {
		
		final String userInput = "1.00";
		final int expectedInput = 1;
		final int actualInput = Store.getChoice(userInput);

		Assert.assertEquals(expectedInput, actualInput);
		
	}
	
	@Test
	public void testRound() {
		double a = 15.40;
		
		int expInt = 15;
		int actInt = (int) ((int) Math.round(a * 10)/10.0);
		
		Assert.assertEquals(expInt, actInt);
	}
	
	@Test
	public void testMathAbs() {
		int a = -15;
		
		int actual = Math.abs(a);
		int expected = 15;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAmount() {
		final String userInput2 = "15.00";
		final double expectedInput = 15.0;
		final double actualInput = Store.getAmount(userInput2);
		
		Assert.assertEquals(expectedInput, actualInput);
	}
	
	@Test
	public void testNegativeGetAmount() {
		final String userInput2 = "-15";
		final double expectedInput = 15.0;
		final double actualInput = Store.getAmount(userInput2);
		
		Assert.assertEquals(expectedInput, actualInput);
	}
	
	@Test
	public void testWordGetAmount() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			final String userInput2 = "fifteen";
			Store.getAmount(userInput2);
			
		});
	}
	 
	
	@Test
	public void testgetCost() {
		Gson gson = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\yasmi\\OneDrive\\Desktop\\products_two.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Product[] result = gson.fromJson(br, Product[].class);
		List<Product> asList = Arrays.asList(result);
		
		int choice = 1;
		
		
		double expCost = 13.50;
		double actCost = Store.getCost(choice, asList);
		
		Assert.assertEquals(expCost, actCost);
	}
	
	
	@Test
	public void testGetChange() {
		
		double expectedChange = 1.50;
		double actualChange = Store.getChange(13.50, 15);
		
		Assert.assertEquals(expectedChange, actualChange);
		
	}
	
}
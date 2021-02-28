

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class StoreTest {
	

	@Test
	public void Music_testGetPrice() {
		final Music music = new Music("song", "artist", 100);

		final double expectedPrice = 100;
		final double actualPrice = music.getPrice();
		final int toleratedDifference = 0;
		Assert.assertEquals(expectedPrice, actualPrice, toleratedDifference);
		
	}
	
	@Test
	public void Store_testGetChoice() {
		
		final String userInput = "1.00";
		final int expectedInput = 1;
		final int actualInput = Store.getChoice(userInput);

		Assert.assertEquals(expectedInput, actualInput);
		
	}
	
	@Test
	public void testRound() {
		double a = 15.00;
		
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
	public void Store_testGetAmount() {
		final String userInput2 = "15.00";
		final int expectedInput = 15;
		final int actualInput = Store.getAmount(userInput2);
		
		Assert.assertEquals(expectedInput, actualInput);
	}
	 
	
	@Test
	public void Store_testgetCost() {
		ArrayList<Music> list = new ArrayList<Music>();
		list.add( new Music("Song Cry", "Jay Z", 350));
		
		int choice = 0;
		
		double expCost = 3.50;
		double actCost = Store.getCost(choice, list);
		
		Assert.assertEquals(expCost, actCost);
	}
	
	
	@Test
	public void Store_testGetChange() {
		
		double expectedChange = 1.50;
		double actualChange = Store.getChange(13.50, 15);
		
		Assert.assertEquals(expectedChange, actualChange);
		
	}
	
	
	//Unable to test if and else statements with sysout.
//	@Test
//	public void store_testgetMessageForChangeIF() {
//		double cost = 13.50;
//		int amount = 15;
//		String expectedMessage = "\nThank you. Your change is £" + 1.50 + ".\n";
//		String actualMessage = Store.getMessageForChange(cost, amount);
//		assertEquals(expectedMessage, actualMessage);
//	}
//	
//	@Test
//	public void store_store_testgetMessageForChangeELSE() {
//		double cost = 13.50;
//		int amount = 12;
//		String expectedMessage ="\nPlease input an amount greater than the price.";
//		String actualMessage = Store.getMessageForChange(cost, amount);
//		
//		assertEquals(expectedMessage, actualMessage);
//			
//	}
	
	
	
	
	
	
	
	
	
}
package hmalika;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StaffTest {
//testing price input
	@Test
	public void testDecimalInput() {
		
		double exp = 13.5;
		
		String inp = "13.50";
		float actual = Float.parseFloat(inp);
		double actualV = (double) actual;

		
		Assert.assertEquals(exp, actualV, 0);
	}
	
	//parse int test
	@Test
	public void testParseInt() {
		String input = "1300";
		
		int actual = Math.abs(Integer.parseInt(input));
		int expected = 1300;
		
		Assert.assertEquals(expected, actual);
	}
	
	
	//remove item from list
	
	@Test
	public void testItemSetStock() {
		List<Product> prd = new ArrayList<>();
		prd.add(new Product("Song", "Artists", 1300, 34));
		
		prd.get(0).setStock(7);
		
		//create a new list with changed stock
		List<Product> pard = new ArrayList<>();
		pard.add(new Product("Song", "Artists", 1300, 7));
		
		
		//compare both lists, to check if setStock works
		int actual = prd.get(0).getStock();
		int expected = pard.get(0).getStock();
		
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testgetDiscountPerc() {
		
		int input = 25;
		
		double actual = Store.getDiscountAsPer(input);
		double expected = 0.75;
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void doubleToInt() {
		
		String input = "14.50";
		
		int expected = 1450;
		
		double priceDO = Double.parseDouble(input);
		int actual = (int) (priceDO * 100);
		
		Assert.assertEquals(expected, actual);
	}
	
	//create a function that only returns input; e.g. getInput();
	
	@Test
	public void absAndParse() {
		String input = "14";
		
		int actual = Math.abs(Integer.parseInt(input));
		int expected = 14;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testDiscountDouble() {
		double input = Math.abs(-12.5);
		
		double actual = Store.getDiscountPerDoub(input);
		
		double expected = 0.875;
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testDiscountInt() {
		int input = Math.abs(1);
		
		double actual = Store.getDiscountAsPer(input);
		
		double expected = 0.99;
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testabsParseInt() {
		String input = "12";
		
		int actual = Store.returnAbsParsedInt(input);
		int expected = 12;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testsAbsParseDouble() {
		String input = "13.45";
		
		double actual = Store.returnAbsParsedDouble(input);
		double expected = 13.45;
		
		Assert.assertEquals(expected, actual, 0);
	}
}

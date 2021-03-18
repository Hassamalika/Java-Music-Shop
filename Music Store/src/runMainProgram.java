package hmalika;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class runMainProgram {
	
	public static List<Product> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		System.out.println("Hello, if...:\n");
				
		System.out.println("you are a customer, Press 1: ");
		System.out.println("you are a staff member, Press 2: ");
		
		list = Product.loadProductsJson();
				
		String input = Store.getInput();
		int number = Integer.parseInt(input);
		int actual = Math.abs(number);
		
		if (actual == 1) {
			Store.applyCustomerSide(list);
		} else {
			Staff.runStaffSide(list);;
		}
		

	}

}

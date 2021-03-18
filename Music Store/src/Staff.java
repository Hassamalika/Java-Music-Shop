package hmalika;

import java.io.IOException;
import java.util.List;

public class Staff {
	
	//public static List<Product> list = new ArrayList<>();
	//call list from product class

	static void runStaffSide(List<Product> list) {
		
		try {
			applyStaffChanges(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	private static void applyStaffChanges(List<Product> list) throws IOException {
		
		System.out.println("Welcome staff members\n");
	
		System.out.println("Here is the current inventory\n");
		Store.printMenu(list);
	
		//print staff options
		staffMainMenu();
		
		String input = Store.getInput();
		int option = returnAbsParsedInt(input);
		
		goToSelectedAction(option, list);
	}
	
	private static void goToSelectedAction(int option, List<Product> list) throws IOException {
		if (option == 1) {
			staffAddProduct(list);
		} else if (option == 2) {
			staffRemoveProduct(list);
		} else if (option == 3) {
			staffChangeStock(list);
		} else if (option == 4) {
			staffApplyDiscount(list);
		} else if (option == 5) {
			Store.applyCustomerSide(list);
		}
	}

	private static void staffMainMenu() {
		System.out.println("\nPlease choose an option below\n");

		System.out.println("1 - Add a product");
		System.out.println("2 - Remove a product");
		System.out.println("3 - Change stock information of a product");
		System.out.println("4 - Apply a discount");
		System.out.println("5 - Run Store with changes\n");
	}

	private static void staffApplyDiscount(List<Product> list) throws IOException {
		
		try {
			System.out.println("Please enter the discount you would like to apply: ");
			String input = Store.getInput();
			float number = returnAbsParsedFloat(input); //use float to be used in if integer/else
			
			if(number%1 == 0) {
				int discount = returnAbsParsedInt(input);
				list = getDiscountedPricesInteger(discount, list);
			} else {
				double discountDouble = returnAbsParsedDouble(input);
				getDiscountedPricesDouble(discountDouble, list);
			}
			showUpdatedList(list);
			backToMainMenu(list);
		} catch(NumberFormatException e) {
			System.out.println("Input not valid.");
			e.printStackTrace();
		}
	}
	
	private static List<Product> getDiscountedPricesDouble(double discountDouble, List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			double percDiscount = getDiscountPerDoub(discountDouble);
			int newPrice = (int) (list.get(i).getPrice() * percDiscount);
			list.get(i).setPrice(newPrice);
		}
		return list;
		
	}

	private static List<Product> getDiscountedPricesInteger(int discount, List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			double percDiscount = getDiscountAsPer(discount);
			int newPrice = (int) (list.get(i).getPrice() * percDiscount);
			list.get(i).setPrice(newPrice);
		}
		return list;
		
	}

	public static double getDiscountAsPer(int discount) {
		double pcDisc = (1 - discount/ 100.0);
		return pcDisc;
	}
	
	public static double getDiscountPerDoub(double discount) {
		double pcDisc = (1 - discount/ 100.0);
		return pcDisc;
	}

	private static void staffChangeStock(List<Product> list) throws IOException {
		
		System.out.println("Please enter the product (by index) you would like to change:");
		 
		String input = Store.getInput();
		int intItem = returnAbsParsedInt(input);
		
		System.out.println("Please enter the new stock information:");
		String inputTwo = Store.getInput();
		int newStock = returnAbsParsedInt(inputTwo);
			
		list.get(intItem).setStock(newStock);
		System.out.println("Updated product information:");
		System.out.println(intItem + list.get(intItem).getMessage());
	
		showUpdatedList(list);
		backToMainMenu(list);
	}

	private static void staffRemoveProduct(List<Product> list) throws IOException {
		System.out.println("Please enter the product (by index) you would like to remove");
		String input = Store.getInput();
		
		int intItem = returnAbsParsedInt(input);
	
		list.remove(intItem);
			
		showUpdatedList(list);
			
		backToMainMenu(list);
	}

	private static void staffAddProduct(List<Product> list) throws IOException {
		
		System.out.println("Please add in the following information:\n");
		
		System.out.println("Enter product song name: ");
		String song = Store.getInput();
		
		System.out.println("Enter product song artists: ");
		String artists = Store.getInput();
			
		System.out.println("Enter product's price: ");
		String priceInp = Store.getInput();
		float priceFloat = returnAbsParsedFloat(priceInp);
		int price;
		
		if(priceFloat % 1== 0) {
			price = returnAbsParsedInt(priceInp);
		} else {
			double priceDouble = returnAbsParsedDouble(priceInp);
			price = (int) (priceDouble * 100);
		}
		
		System.out.println("Enter product's stock: ");
		String stockInp = Store.getInput();
		int stock = returnAbsParsedInt(stockInp);
		
		Product newProduct = new Product(song, artists, price, stock);
		list.add(newProduct);
			
		showUpdatedList(list);
		
		backToMainMenu(list);
		
	}
	
	public static float returnAbsParsedFloat(String input) {
		float output = 0;
		try {
			output = Math.abs(Float.parseFloat(input));
		} catch(NumberFormatException e) {
			System.out.println("Invalid input.");
			e.printStackTrace();
		}
		return output;
	}

	public static int returnAbsParsedInt(String input) {
		int output = 0;
		try {
			output = Math.abs(Integer.parseInt(input));
		} catch(NumberFormatException e) {
			System.out.println("Invalid input.");
			e.printStackTrace();
		}
		return output;
	}
	
	public static double returnAbsParsedDouble(String input) {
		double output = 0;
		try {
		output = Math.abs(Double.parseDouble(input));
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			e.printStackTrace();
		}
		return output;
	}
	
	private static void showUpdatedList(List<Product> list) {
		System.out.println("Here is the updated list\n");
		Store.printMenu(list);
	}
	
	private static void backToMainMenu(List<Product> list) {
		
		try {
			
			System.out.println("\nWould you like to go back to the main menu (Y/N)?");
			String option = Store.getInput();
			
			if("Y".equalsIgnoreCase(option)) {
				//Store.runFirstMenu();
				applyStaffChanges(list);
			}
			else if("Yes".equalsIgnoreCase(option)) {
				//runFirstMenu();
				applyStaffChanges(list);	
			}
			else if("No".equalsIgnoreCase(option)) {
				System.out.println("Thank you. Goodbye.");
				return;
			}
			else if("N".equalsIgnoreCase(option)) {
				System.out.println("Thank you. Goodbye.");
				return;
			}
			else {
				System.out.println("Please input Y/yes or N/no.");
				backToMainMenu(list);
			} 
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

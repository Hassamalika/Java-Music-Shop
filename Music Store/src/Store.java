package hmalika;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Store {

	private static List<Product> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		Gson gson = new Gson();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\yasmi\\OneDrive\\Desktop\\products_two.json"));
			Product[] result = gson.fromJson(br, Product[].class);
			List<Product> asList = Arrays.asList(result);

			list.addAll(asList);
				
			System.out.println("Hello, if...:\n");
	
			System.out.println("you are a customer, Press 1: ");
			System.out.println("you are a staff member, Press 2: ");
			String input = getInput();
			
			int number = Integer.parseInt(input);
			int actual = Math.abs(number);
	
			if (actual == 1) {
				runCustomerSide(list);
			} else {
				applyStaffChanges(list);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void runCustomerSide(List<Product> list) {
		printHeader();
		printMenu(list);
		try {
			runMenu();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please enter a choice from the menu.");
			runMenu();
		} catch (NumberFormatException e) {
			System.out.println("Please enter an integer.");
		} catch (Exception e) {
			System.out.println("Some other exception has occured.");
		}
	}

	static void printHeader() {
		System.out.println("+----------------------------------------+");
		System.out.println("|          Welcome to my shop!           |");
		System.out.println("+----------------------------------------+");
		System.out.println("\n\nWe have the following CD's in stock.\n");
	}

	static void printMenu(List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + list.get(i).getMessage());
		}
	}

//--------------------------------------------------------------------------------------------------------------
//														CUSTOMER	
	static void runMenu() {

		showMessage1();

		int choice = askForCDChoice();
		double cost = getCost(choice, list);

		showMessage2(cost);

		showMessage3();

		double amount;
		try {
			amount = askForAmount();
			getMessageForChange(cost, amount);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		changeStockInfo(choice, list);

	}

	public static int askForCDChoice() {
		String userInput = null;
		userInput = getInput();
		int choice = getChoice(userInput);
		return choice;

	}

	public static double getCost(int choice, List<Product> list) {
		int ab = list.get(choice).getPrice();
		return ab / 100.0;
	}

	public static double askForAmount() throws NumberFormatException, IOException {
		final String userInput2 = getInput();
		double amount = getAmount(userInput2);
		return amount;
	}

	public static String getInput() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputOne = null;
		
		try {
			inputOne = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
		return inputOne;
		
	}

	public static int getChoice(String userInput) {
		float a = Math.abs(Float.parseFloat(userInput));
		return Math.round(a);
	}

	public static double getAmount(String userInput2) throws NumberFormatException {
		float b = Math.abs(Float.parseFloat(userInput2));
		return (double) b;
	}

	static void getMessageForChange(double cost, double amount) throws NumberFormatException, IOException {
		if (amount >= cost) {
			double change = getChange(cost, amount);

			System.out.println("\nThank you. Your change is £" + String.format("%.2f", change) + ".\n");
		} else {
			System.out.println("\nPlease input an amount greater than the price.");
			runMenu();
		}
	}

	public static double getChange(double cost, double amount) {
		double c = amount - cost;
		return c;
	}

	static void showMessage1() {
		System.out.println("\nPlease input which CD you would like:");
	}

	static void showMessage2(double cost) {
		System.out.println("Thank you that will be £" + String.format("%.2f", cost) + ".\n");
	}

	static void showMessage3() {
		System.out.println("\nPlease input how much you would like to give me:");
	}

	static void changeStockInfo(int choice, List<Product> list) {
		System.out.println("-------------------------------------");
		System.out.println("Updated inventory after purchase:\n");
		list.get(choice).setStock(list.get(choice).getStock() - 1);
		printMenu(list);

	}

//-------------------------------------------------------------------------------------------------------------
//                                                  STAFF	

	private static void applyStaffChanges(List<Product> list) throws IOException {
		
		System.out.println("Welcome staff members\n");
	
		System.out.println("Here is the current inventory\n");
		printMenu(list);
	
		//print staff options
		staffMainMenu();
		
		String input = getInput();
		int option = returnAbsParsedInt(input);
		
		goToSelectedAction(option);
	}
	
	

	private static void goToSelectedAction(int option) throws IOException {
		if (option == 1) {
			staffAddProduct(list);
		} else if (option == 2) {
			staffRemoveProduct(list);
		} else if (option == 3) {
			staffChangeStock(list);
		} else if (option == 4) {
			staffApplyDiscount(list);
		} else if (option == 5) {
			runCustomerSide(list);
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
		
		System.out.println("Please enter the discount you would like to apply: ");
		String input = getInput();
		float number = Math.abs(Float.parseFloat(input));
		
		if(number%1 == 0) {
			int discount = returnAbsParsedInt(input);
			list = getDiscountedPricesInteger(discount);
		} else {
			double discountDouble = returnAbsParsedDouble(input);
			getDiscountedPricesDouble(discountDouble);
		}
		showUpdatedList(list);
		backToMainMenu(list);

	}
	

	private static List<Product> getDiscountedPricesDouble(double discountDouble) {
		for (int i = 0; i < list.size(); i++) {
			double percDiscount = getDiscountPerDoub(discountDouble);
			int newPrice = (int) (list.get(i).getPrice() * percDiscount);
			list.get(i).setPrice(newPrice);
		}
		return list;
		
	}

	private static List<Product> getDiscountedPricesInteger(int discount) {
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
		
		String input = getInput();
		//create function that returnsAbsoluteInt()
		int intItem = returnAbsParsedInt(input);
		
		System.out.println("Please enter the new stock information:");
		String inputTwo = getInput();
		int newStock = returnAbsParsedInt(inputTwo);
			
		list.get(intItem).setStock(newStock);
		System.out.println("Updated product information:");
		System.out.println(intItem + list.get(intItem).getMessage());
	
		showUpdatedList(list);
		backToMainMenu(list);
	}

	private static void staffRemoveProduct(List<Product> list) throws IOException {
		System.out.println("Please enter the product (by index) you would like to remove");
		String input = getInput();
		
		int intItem = returnAbsParsedInt(input);
	
		list.remove(intItem);
			
		showUpdatedList(list);
			
		backToMainMenu(list);
	}

	private static void staffAddProduct(List<Product> list) throws IOException {
		
		System.out.println("Please add in the following information:\n");
		
		System.out.println("Enter product song name: ");
		String song = getInput();
		
		System.out.println("Enter product song artists: ");
		String artists = getInput();
			
		System.out.println("Enter product's price: ");
		String priceInp = getInput();
		
		float priceFloat = Float.parseFloat(priceInp);
		int price;
		
		if(priceFloat % 1== 0) {
			price = returnAbsParsedInt(priceInp);
		} else {
			double priceDouble = returnAbsParsedDouble(priceInp);
			price = (int) (priceDouble * 100);
		}
		
		System.out.println("Enter product's stock: ");
		String stockInp = getInput();
		int stock = returnAbsParsedInt(stockInp);
		
		Product newProduct = new Product(song, artists, price, stock);
		list.add(newProduct);
			
		showUpdatedList(list);
		
		backToMainMenu(list);
		
	}
	
	public static int returnAbsParsedInt(String input) {
		int output = Math.abs(Integer.parseInt(input));
		return output;
	}
	
	public static double returnAbsParsedDouble(String input) {
		double output = Math.abs(Double.parseDouble(input));
		return output;
	}
	
	private static void showUpdatedList(List<Product> list) {
		System.out.println("Here is the updated list\n");
		printMenu(list);
	}
	
	private static void backToMainMenu(List<Product> list) {
		
		try {
			
			System.out.println("\nWould you like to go back to the main menu (Y/N)?");
			String option = getInput();
			
			if("Y".equalsIgnoreCase(option)) {
				applyStaffChanges(list);
			}
			else if("Yes".equalsIgnoreCase(option)) {
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

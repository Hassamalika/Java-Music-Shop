package hmalika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Store {

	static void applyCustomerSide(List<Product> list) {
		printHeader();
		printMenu(list);
		try {
			runMenu(list);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please enter a choice from the menu.");
			runMenu(list);
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
	static void runMenu(List<Product> list) {

		showMessage1();

		int choice = askForCDChoice();
		double cost = getCost(choice, list);

		showMessage2(cost);

		showMessage3();

		double amount;
		try {
			amount = askForAmount();
			getMessageForChange(cost, amount, list);
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

	static void getMessageForChange(double cost, double amount, List<Product> list) throws NumberFormatException, IOException {
		if (amount >= cost) {
			double change = getChange(cost, amount);

			System.out.println("\nThank you. Your change is £" + String.format("%.2f", change) + ".\n");
		} else {
			System.out.println("\nPlease input an amount greater than the price.");
			runMenu(list);
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
}
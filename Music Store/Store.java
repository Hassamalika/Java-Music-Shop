package hmalika;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.text.DecimalFormat;
//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);

		System.out.println("Hello, if...:\n");

		System.out.println("you are a customer, Press 1: ");
		System.out.println("you are a staff member, Press 2: ");
		int number = console.nextInt();

		if (number == 1) {
			runCustomerSide(list);
		} else {
			applyStaffChanges(list);
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
		System.out.println("Updated inventory after purchase:\n");
		changeStockInfo(choice, list);

	}

	public static int askForCDChoice() {
		String userInput = null;
		try {
			userInput = getInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public static String getInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String inputOne = reader.readLine();
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

		list.get(choice).setStock(list.get(choice).getStock() - 1);
		printMenu(list);

	}

//-------------------------------------------------------------------------------------------------------------
//                                                  STAFF	

	private static void applyStaffChanges(List<Product> list) throws IOException {
		
		BufferedReader bra = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Welcome staff members\n");
	
			System.out.println("Here is the current inventory\n");
	
			printMenu(list);
	
			staffMainMenu();
			
			String optionStr = bra.readLine();
			int option = Math.abs(Integer.parseInt(optionStr));
			
			goToSelectedAction(option);
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Another error has occured");
			e.printStackTrace();
		} finally {
			try {
				bra.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
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
		System.out.println("Please choose an option below\n");

		System.out.println("1 - Add a product");
		System.out.println("2 - Remove a product");
		System.out.println("3 - Change stock information of a product");
		System.out.println("4 - Apply a discount");
		System.out.println("5 - Run Store with changes\n");
	}

	private static void staffApplyDiscount(List<Product> list) throws NumberFormatException {
		
		BufferedReader bre = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Please enter the discount (as integer) you would like to apply: ");
			String disc = bre.readLine();
			int discount = Math.abs(Integer.parseInt(disc));
			
			for (int i = 0; i < list.size(); i++) {
			double percDiscount = getDiscountAsPer(discount);
			int newPrice = (int) (list.get(i).getPrice() * percDiscount);
			list.get(i).setPrice(newPrice);
			}
			
			showUpdatedList(list);
			
			backToMainMenu(list);
			
		} catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				bre.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static double getDiscountAsPer(int discount) {
		double pcDisc = (1 - discount/ 100.0);
		return pcDisc;
	}

	private static void staffChangeStock(List<Product> list) {
		
		BufferedReader brt = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Please enter the product (by index) you would like to change:");
			
			String item = brt.readLine();
			int intItem = Math.abs(Integer.parseInt(item));
			
			System.out.println("Please enter the new stock information:");
			String stock = brt.readLine();
			int newStock = Math.abs(Integer.parseInt(stock));
			
			list.get(intItem).setStock(newStock);
			System.out.println("Updated product information:");
			System.out.println(item + list.get(intItem).getMessage());
	
			showUpdatedList(list);
			
			backToMainMenu(list);
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			try {
				brt.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void staffRemoveProduct(List<Product> list) {
		
		BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Please enter the product (by index) you would like to remove");
			String item = brr.readLine();
			int intItem = Math.abs(Integer.parseInt(item));
	
			list.remove(intItem);
			
			showUpdatedList(list);
			
			backToMainMenu(list);
			
		} catch(IOException e ) {
			e.printStackTrace();
		} finally {
			try {
				brr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void staffAddProduct(List<Product> list) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Please add in the following information:\n");
		
			System.out.println("Enter product song name: ");
			String song = br.readLine();
		
			System.out.println("Enter product song artists: ");
			String artists = br.readLine();
			
			System.out.println("Enter product's price: ");
			String priceInp = br.readLine();
			
			double priceDouble = Math.abs(Double.parseDouble(priceInp));
			int price = (int) (priceDouble * 100);
			
			
			System.out.println("Enter product's stock: ");
			String stockInp = br.readLine();
			int stock = Math.abs(Integer.parseInt(stockInp));
			
			Product newProduct = new Product(song, artists, price, stock);
			list.add(newProduct);
			
			showUpdatedList(list);
			
			backToMainMenu(list);
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	private static void showUpdatedList(List<Product> list) {
		System.out.println("Here is the updated list\n");
		printMenu(list);
	}
	
	private static void backToMainMenu(List<Product> list) {
		
		BufferedReader bry = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("\nWould you like to go back to the main menu (Y/N)?");
			
			String option = bry.readLine();
			
			
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bry.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

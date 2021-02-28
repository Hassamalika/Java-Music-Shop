import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Store {
	
	
	private static ArrayList<Music> songs = new ArrayList<Music>();
		
	
	public static void main(String[] args ) throws NumberFormatException, IOException  {
		
		songs.add(new Music("Song Cry", "Jay Z", 350));
		songs.add(new Music("Real Love", "Mary J.Blige", 1350));
		songs.add(new Music("Bad Habits", "Usher", 2650));
		songs.add(new Music("Trip", "Ella Mai", 4000));
		
		printHeader();
		printMenu(songs);
		runMenu();
	}
	
	static void printHeader() {
		System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
	}
	
	//test?
	static void printMenu(ArrayList<Music> songs) {
		for(int i = 0; i < songs.size(); i++) {
			System.out.println(i + songs.get(i).getMessage());
		}
	}
	
	static void runMenu() throws NumberFormatException, IOException {
		
		showMessage1();
		
		int choice = askForCDChoice();
		double cost = getCost(choice, songs);
		
		showMessage2(cost);
		
		showMessage3();
		
		int amount = askForAmount();
		getMessageForChange(cost, amount);
		
	}
	
	static int askForCDChoice() throws NumberFormatException, IOException {
		final String userInput = getInput();
		int choice = getChoice(userInput);
		return choice;
	}
	
	static String getInput() throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String inputOne = reader.readLine();
		return inputOne;
	}
	
	//abs to ignore negative numbers and round to ignore inputs with .00 (e.g. 15.00). 
	static int getChoice(String userInput) {
		float a = Math.abs(Float.parseFloat(userInput));
		return Math.round(a);
	}
	
	static double getCost(int choice, ArrayList<Music> songs) {
		double ab = songs.get(choice).getPrice();
		return ab;
	}
	
	static int askForAmount() throws NumberFormatException, IOException {
		final String userInput2 = getInput();
		int amount = getAmount(userInput2);
		return amount;
	}
	
	static int getAmount(String userInput2) {
		float b = Math.abs(Float.parseFloat(userInput2));
		return Math.round(b);	
	}
	
	//show chnage to user, else runMenu again to prompt for higher amount
	static void getMessageForChange(double cost, int amount) throws NumberFormatException, IOException {
		if (amount >= cost){
			double change = getChange(cost, amount);
			System.out.println("\nThank you. Your change is £" + String.format("%.2f", change)+ ".\n");
			}
		else {
			System.out.println("\nPlease input an amount greater than the price.");
			runMenu();
		}
	}
	
	//get change
	static double getChange(double cost, int amount) {
		double c = amount - cost;
		return c;
	}	
	
	//messages
	static void showMessage1() {
		System.out.println("\nPlease input which CD you would like:");
	}
	
	static void showMessage2(double cost) {
		System.out.println("Thank you that will be £" + String.format("%.2f", cost) + ".\n");
	}
	
	static void showMessage3() {
		System.out.println("\nPlease input how much you would like to give me:");
	}
	
	
}


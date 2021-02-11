
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Shop {
	boolean exit;

    public static void main(String[] args) throws NumberFormatException, IOException {

        Shop shop = new Shop();
        shop.runMenu();
    }

    public void runMenu() throws NumberFormatException, IOException {
        printHeader();
        while (!exit) {
            Menu();
            int choice = getInput();
            showChange(choice);
        }

    }

    private void printHeader() {
        System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");

        System.out.println("\n\nWe have the following CD's in stock.\n");
    }

    
    public static ArrayList<Music> songOne;
	public static ArrayList<Music> songTwo;
	public static ArrayList<Music> songThree;
	public static ArrayList<Music> songFour;

    public void Menu() {
        
        songOne = new ArrayList<>();
		songTwo = new ArrayList<>();
		songThree = new ArrayList<>();
		songFour = new ArrayList<>();

		Music s1 = new Music(1, "Song Cry", "Jay Z", 3.50);
		Music s2 = new Music(2, "Real Love", "Mary J.Blige", 13.50);
		Music s3 = new Music(3, "Bad Habits", "Usher", 26.50);
		Music s4 = new Music(4, "Trip", "Ella Mai", 40.00);

		songOne.add(s1);
		songTwo.add(s2);
		songThree.add(s3);
		songFour.add(s4);
		
		 
		System.out.println(s1.showMessage());
		System.out.println(s2.showMessage());
		System.out.println(s3.showMessage());
		System.out.println(s4.showMessage());
		System.out.println("0 - Input to exit.");
    }
    
    private int getInput() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.println("\nPlease input which CD you want:\n");
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
	}

    public ArrayList<Music> getListOne() {
		return songOne;
	}
	
	static ArrayList<Music> getListTwo(){
		return songTwo;
	}
	
	static ArrayList<Music> getListThree(){
		return songThree;
	}
	
	static ArrayList<Music> getListFour(){
		return songFour;
	}

    private void showChange(int choice) throws NumberFormatException, IOException 
	{
		Shop sg = new Shop();
		double p1;
		double p2;
		double p3;
		double p4;
		p1 = sg.returnCostOne();
		p2 = sg.returnCostTwo();
		p3 = sg.returnCostThree();
		p4 = sg.returnCostFour();
		
		switch (choice) 
		{
		case 0:
			exit = true;
            System.out.println("\nThank you for shopping. Goodbye.");
            break;
            
		case 1:
			System.out.println("Thank you that will be " + String.format("%.2f", p1) + ".\n");
			getChange(p1);
			break;

		case 2:
			System.out.println("Thank you that will be " + String.format("%.2f", p2) + ".\n");
			getChange(p2);
			break;

		case 3:
			System.out.println("Thank you that will be " + String.format("%.2f", p3) + ".\n");
			getChange(p3);
			break;

		case 4:
			System.out.println("Thank you that will be " + String.format("%.2f", p4) + ".\n");
			getChange(p4);
			break;
			
		default:
			System.out.println("An error has occurred.");
		}
	}
    
    private void getChange(double price) throws NumberFormatException, IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nPlease input how much you would like to give me:");
		int amount = Integer.parseInt(br.readLine());
        double change;
        if (amount >= price) 
        {
		    change = amount - price;
		 	System.out.println("\nThank you. Your change is " + String.format("%.2f", change) + ".\n");
		}

		else 
		{
		 	System.out.println("\nPlease input an amount greater than the price.");
        }
	}

    private double price1;
	private double price2;
	private double price3;
	private double price4;

    public double returnCostOne() {

		for (int i = 0; i < getListOne().size(); i++) {
		 	price1 = getListOne().get(i).returnPrice();
		}
		return price1;
	}

	public double returnCostTwo() {

		for (int i = 0; i < getListTwo().size(); i++) {
		 	price2 = getListTwo().get(i).returnPrice();
		}
		return price2;
	}

	public double returnCostThree() {

		for (int i = 0; i < getListThree().size(); i++) {
		 	price3 = getListThree().get(i).returnPrice();
		}
		return price3;
	}

	public double returnCostFour() {

		for (int i = 0; i < getListFour().size(); i++) {
		 	price3 = getListFour().get(i).returnPrice();
		}
		return price4;
	}

	

	

}


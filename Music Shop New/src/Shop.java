import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void Menu() {
        Music s1 = new Music();
        Music s2 = new Music();
        Music s3 = new Music();
        Music s4 = new Music();

        s1.songOne();
        s2.songTwo();
        s3.songThree();
        s4.songFour();

        s1.showMessage();
        s2.showMessage();
        s3.showMessage();
        s4.showMessage();

        System.out.println("0 - Press to Exit");

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

	private void showChange(int choice) throws NumberFormatException, IOException 
	{
		// find a way to avoid repeating this section below
		// to access variables from Music class 
		Music s1 = new Music();
		Music s2 = new Music();
		Music s3 = new Music();
		Music s4 = new Music();
		
		s1.songOne();
		s2.songTwo();
		s3.songThree();
		s4.songFour(); 
		
		double price1 = s1.returnPrice();
		double price2 = s2.returnPrice();
		double price3 = s3.returnPrice();
		double price4 = s4.returnPrice();
		
		switch (choice) 
		{
		case 0:
			exit = true;
            System.out.println("\nThank you for shopping. Goodbye.");
            break;
            
		case 1:
			System.out.println("Thank you that will be " + price1 + ".\n");
			getChange(price1);
			break;

		case 2:
			System.out.println("Thank you that will be " + price2 + ".\n");
			getChange(price2);
			break;

		case 3:
			System.out.println("Thank you that will be " + price3 + ".\n");
			getChange(price3);
			break;

		case 4:
			System.out.println("Thank you that will be " + price4 + ".\n");
			getChange(price4);
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
		 	System.out.println("\nThank you. Your change is: " + String.format("%.2f", change) + ".\n");
		}

		else 
		{
		 	System.out.println("\nPlease input an amount greater than the price.");
        }
	}

}

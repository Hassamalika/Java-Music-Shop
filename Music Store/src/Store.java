import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Store {
	static boolean exit;
	
	public static void main(String[] args ) throws NumberFormatException, IOException {
		
	//prints header
		System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
        
	//list of songs
        ArrayList<Music> songs;
		songs = new ArrayList<>();
	
		Music s1 = new Music(1, "Song Cry", "Jay Z", 3.50);
		Music s2 = new Music(2, "Real Love", "Mary J.Blige", 13.50);
		Music s3 = new Music(3, "Bad Habits", "Usher", 26.50);
		Music s4 = new Music(4, "Trip", "Ella Mai", 40.00);
	
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		
		//print menu/stock
		System.out.println("0 - Input to exit.");
		for(int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).getMessage());
		}
		
		//get user input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nPlease input how much you would like to give me:");
		int choice;
		choice = Integer.parseInt(reader.readLine());
		
		//show price
		//and from input calculate change
		
		double cost1;
		double cost2;
		double cost3;
		double cost4;
		
		if (choice == 0)
		{
			System.out.println("\nThank you for shopping. Goodbye.");
			exit = true;
		}
		else if(choice == 1)
		{
			cost1 = songs.get(0).getPrice();
			System.out.println("Thank you that will be " + String.format("%.2f", cost1) + ".\n");
			getChange(cost1);
		}
		else if(choice == 2)
		{
			cost2 = songs.get(1).getPrice();
			System.out.println("Thank you that will be " + String.format("%.2f", cost2) + ".\n");
			getChange(cost2);
		}
		else if(choice == 3)
		{
			cost3 = songs.get(2).getPrice();
			System.out.println("Thank you that will be " + String.format("%.2f", cost3) + ".\n");
			getChange(cost3);
		}
		else if (choice == 4)
		{
			cost4 = songs.get(3).getPrice();
			System.out.println("Thank you that will be " + String.format("%.2f", cost4) + ".\n");
			getChange(cost4);
		}
	}
		
	//calculate change
	public static void getChange(double cost) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nPlease input how much you would like to give me:");
		int amount = Integer.parseInt(br.readLine());
        double change;
        if (amount >= cost) 
        {
		    change = amount - cost;
		 	System.out.println("\nThank you. Your change is " + String.format("%.2f", change) + ".\n");
		}

		else 
		{
		 	System.out.println("\nPlease input an amount greater than the price.");
        }
	}
}

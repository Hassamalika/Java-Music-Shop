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
		
		double cost;
		
		for (int i = 0; i < choice; i++) {
			cost = songs.get(i).getPrice();
			System.out.println("Thank you that will be " + String.format("%.2f", cost) + ".\n");
			getChange(cost);
		}
		
		if(choice == 0) {
				System.out.println("\nThank you for shopping. Goodbye.");
				exit = true;
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

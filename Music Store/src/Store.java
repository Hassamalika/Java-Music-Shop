import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Store {
	
	public static void main(String[] args ) throws NumberFormatException, IOException {
		
	//prints header
		System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
        System.out.println("\n\nWe have the following CD's in stock.\n");
        
	//list of songs
        ArrayList<Music> songs;
		songs = new ArrayList<>();
	
		Music s1 = new Music("Song Cry", "Jay Z", 3.50);
		Music s2 = new Music("Real Love", "Mary J.Blige", 13.50);
		Music s3 = new Music("Bad Habits", "Usher", 26.50);
		Music s4 = new Music("Trip", "Ella Mai", 40.00);
	
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		
		for(int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).getMessage());
		}
		
		//get user input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nPlease input which CD you would like:");
		int choice;
		choice = Integer.parseInt(reader.readLine());
		
		double cost;
		
		cost = songs.get(i).getPrice(choice);
		System.out.println("Thank you that will be " + String.format("%.2f", cost) + ".\n");
		getChange(cost);
		
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

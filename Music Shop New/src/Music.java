public class Music {
	
	private int id;
	private String song;
	private String artist;
	private double price;		
	
	public void songOne() {
		
		this.id = 1;
		this.song = "Song Cry";
		this.artist = "Jay Z";
		this.price = 3.50;
	}

	
	public void songTwo() {
		
		this.id = 2;
		this.song = "Real Love";
		this.artist = "Mary J.Blige";
		this.price = 13.50;
	}
		
		
	public void songThree() {
		
		this.id = 3;
		this.song = "Bad Habits";
		this.artist = "Usher";
		this.price = 26.50;
	}
		
	public void songFour() {
		
		this.id = 4;
		this.song = "Trip";
		this.artist = "Ella Mai";
		this.price = 40.00;
	}

	public double returnPrice() {
		return this.price;
		
	}
	
	public void showMessage() 
	{
		System.out.println(id + " - " + song + ", "  + artist + ", Price: £ " + String.format("%.2f", price)); 	
	}
	
}

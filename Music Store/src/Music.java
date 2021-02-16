public class Music {
	
	final String song;
	final String artist;
	final double price;		
		
	public Music(String song, String artist, double price) {
		this.song = song;
		this.artist =artist;
		this.price = price;
	}
		

	public double returnPrice() {
		return this.price;
	}
		
	public String showMessage() 
	{
		return (" - " + song + ", "  + artist + ", Price: £" + String.format("%.2f", price));	
	}

}

public class Music {
		
	final String song;
	final String artist;
	final int price;		
		
	public Music(String song, String artist, int price) {
		this.song = song;
		this.artist =artist;
		this.price = price;
	}
		

	public double getPrice() {
		return this.price/ 100.0;
	}
		
	public String getMessage() 
	{
		return (" - " + song + ", "  + artist + ", Price: £" + String.format("%.2f", price/ 100.0));	
	}

} 

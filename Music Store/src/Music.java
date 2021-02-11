public class Music {
		
	final int id;
	final String song;
	final String artist;
	final double price;		
		
	public Music(int id, String song, String artist, double price) {
		this.id = id;
		this.song = song;
		this.artist =artist;
		this.price = price;
	}
		

	public double returnPrice() {
		return this.price;
	}
		
	public String showMessage() 
	{
		return (id + " - " + song + ", "  + artist + ", Price: £" + String.format("%.2f", price));	
	}

}

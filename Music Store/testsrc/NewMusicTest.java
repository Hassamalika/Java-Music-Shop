
//import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class NewMusicTest {

	Music target;
	
	@Before
	public void setUp() {
		
	}
	
	//@Test
//	public void testListEmpty() {
//		assertTrue(actualList.isEmpty());
//	}
	@Test
	public void Music_testElements() {
		
		final Music target = new Music("Song Cry", "Jay Z", 350);
		
		final int price = 350;
		final String songName = "Song Cry";
		final String artist = "Jay Z";
		//expectedList.add(new Music("Song Cry", "Jay Z", 3.50));
		
		
		assertEquals(price, target.price);
		assertEquals(songName, target.song);
		assertEquals(artist, target.artist);
	}
	
	@Test
	public void Music_testgetMessage() {
		final Music target = new Music("Song Cry", "Jay Z", 350);
//		String song = target.song;
//		String artist = target.artist;
//		int price = target.price;
		
		String expMessage = " - Song Cry, Jay Z, Price: £3.50";
		String actMessage = target.getMessage();
		
		Assert.assertEquals(expMessage, actMessage);
		
	}
	
	@Test
	public void Music_getPrice() {
		final Music target = new Music("Song Cry", "Jay Z", 350);
		double expPrice = 3.50;
		
		double actualPrice = target.getPrice();
		
		Assert.assertEquals(expPrice, actualPrice, 0);
	}
	

}

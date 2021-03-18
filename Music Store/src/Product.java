package hmalika;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Product {
	
	public static List<Product> list = new ArrayList<>();
	
	public static List<Product> loadProductsJson() {
		Gson gson = new Gson();
		BufferedReader br = null;
	
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\yasmi\\OneDrive\\Desktop\\products_two.json"));
			Product[] result = gson.fromJson(br, Product[].class);
			List<Product> asList = Arrays.asList(result);
	
			list.addAll(asList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////

	
	@SerializedName("song")
	@Expose
	private String song = null;
	@SerializedName("artists")
	@Expose
	private String artists = null;
	@SerializedName("price")
	@Expose
	private Integer price = null;
	@SerializedName("stock")
	@Expose
	private Integer stock = null;
	
	public Product(String song, String artists, int price, int stock) {
		this.artists = artists;
		this.song = song;
		this.price = price;
		this.stock = stock;
	}

	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getMessage() 
	{
		return (" - " + song + ", "  + artists + ", Price: £" + String.format("%.2f", price/ 100.0) + ", Stock: " + stock);	
	}
	
	

}
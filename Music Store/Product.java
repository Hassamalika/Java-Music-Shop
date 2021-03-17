package hmalika;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

	
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
	
	@SerializedName("products")
	@Expose
	private List<Product> products = null;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
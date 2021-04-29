import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Product {

    public static List<Product> list = new ArrayList<>();

    public static List<Product> loadProductsJson() {
        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("products.json"));
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
    private final String song;
    @SerializedName("artists")
    @Expose
    private final String artists;
    @SerializedName("price")
    @Expose
    private BigDecimal price;
    @SerializedName("stock")
    @Expose
    private Integer stock;

    public Product(String song, String artists, BigDecimal price, int stock) {
        this.artists = artists;
        this.song = song;
        this.price = price;
        this.stock = stock;
    }

    public BigDecimal getPrice() {

        price = price.setScale(2, RoundingMode.HALF_EVEN);
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public String getMessage()
    {
        return (" - " + song + ", "  + artists + ", Price: £" + new DecimalFormat("###.00").format(price) + ", Stock: " + stock);
    }
}

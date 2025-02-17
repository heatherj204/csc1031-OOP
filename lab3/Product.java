import java.util.ArrayList;
import java.util.List;
public class Product {
    private String productName;
    private long price;
    private boolean inStock;
    private List<String> tags;

    public Product(String productName, long price, boolean inStock, List<String> tags){
        //this.productName = productName;
        if (productName == null) {
            this.productName = "Unknown";
        }else{
            this.productName = productName;
        }
        if (price < 0) {
            this.price = 0;
        }else{
            this.price = price;
        }
        this.inStock = inStock;
        if (tags == null) {
            this.tags = new ArrayList<String>();
        } else {
            this.tags = new ArrayList<String>(tags);
        }
    }

    public Product(){
        this("Unknown", 0, false, new ArrayList<>());
    }

    public Product(String productName){
        this(productName, 0, false, new ArrayList<>());
    }

    public Product(String productName, long price){
        this(productName, price, false, new ArrayList<>());
    }

    public Product(String productName, long price, boolean inStock){
        this(productName, price, inStock, new ArrayList<>());
    }

    public Product(String productName, long price, List<String> tags){
        this(productName, price, false, tags);
    }

    // Deep copy
    public Product(Product deepCopy){
        this(deepCopy.productName, deepCopy.price, deepCopy.inStock, new ArrayList<String>(deepCopy.tags) );
    }

    // Getter
    public List<String> getTags(){
        return this.tags;
    }

    // Setter
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    // Override the to string function
    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", tags=" + tags +
                '}';
    }
}

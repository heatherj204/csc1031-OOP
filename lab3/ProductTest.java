import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product.toString());

        Product product2 = new Product("Monster Pipeline Punch");
        System.out.println(product2.toString());

        List<String> tags = new ArrayList<>();
        tags.add("sweets");
        tags.add("popular");

        Product product3 = new Product("Cookie", 1, true, tags);
        System.out.println(product3.toString());

        Product product4 = new Product(product3);
        System.out.println(product4.getTags());
        product4.addTag("cheap");
        System.out.println(product4.getTags());

    }
}


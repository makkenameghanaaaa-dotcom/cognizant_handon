import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int comparison =
                    products[mid].productName.compareToIgnoreCase(name);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories")
        };

        String searchItem = "Phone";

        // Linear Search
        Product result1 = linearSearch(products, searchItem);

        if (result1 != null) {
            System.out.println("Linear Search Found:");
            System.out.println(result1.productId + " "
                    + result1.productName + " "
                    + result1.category);
        }

        // Sort before Binary Search
        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        Product result2 = binarySearch(products, searchItem);

        if (result2 != null) {
            System.out.println("\nBinary Search Found:");
            System.out.println(result2.productId + " "
                    + result2.productName + " "
                    + result2.category);
        }
    }
}
import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    private String categoryName;

    public BookCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class ClothingCategory implements Category {
    private String categoryName;

    public ClothingCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class GadgetCategory implements Category {
    private String categoryName;

    public GadgetCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(name + " | " + category.getCategoryName() + " | ₹" + price);
    }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}

public class MarketplaceApp {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Programming", 500.0, new BookCategory("Education"));
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 800.0, new ClothingCategory("Men's Wear"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000.0, new GadgetCategory("Electronics"));

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 15);
        MarketplaceUtils.applyDiscount(phone, 5);

        for (Product<? extends Category> product : catalog) {
            product.displayProduct();
        }
    }
}

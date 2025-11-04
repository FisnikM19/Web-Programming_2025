package mk.ukim.finki.wp2025.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp2025.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// In-memory data holder
@Component
public class DataHolder {

    public static List<Category> categories = null;
    public static List<Manufacturer> manufacturers = null;
    public static List<Product> products = null;
    public static List<User> users = null;

    // On application startup, initialize the in-memory lists with predefined data
    // On each startup, the lists will be initialized with the same values and the previous values will be lost

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category("Movies", "Movies Category"));
        categories.add(new Category("Books", "Books Category"));
        categories.add(new Category("Clothes", "Clothes Category"));

        manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Mango", "Spain"));
        manufacturers.add(new Manufacturer("Nike", "USA"));
        manufacturers.add(new Manufacturer("Amazon", "USA"));

        products = new ArrayList<>();
        products.add(new Product(
                "Sneakers 1",
                4300.00,
                5,
                ProductLevel.NORMAL,
                categories.get(2),
                manufacturers.get(1)
        ));
        products.add(new Product(
                "Sneakers 2",
                6300.00,
                5,
                ProductLevel.SILVER,
                categories.get(2),
                manufacturers.get(1)
        ));

        users = new ArrayList<>();
        users.add(new User("elena.atanasoska", "ea", "Elena", "Atanasoska"));
        users.add(new User("darko.sasanski", "ds", "Darko", "Sasanski"));
        users.add(new User("ana.todorovska", "at", "Ana", "Todorovska"));
    }
}

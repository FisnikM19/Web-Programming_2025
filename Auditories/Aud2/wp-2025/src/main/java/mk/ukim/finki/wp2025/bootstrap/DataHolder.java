package mk.ukim.finki.wp2025.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp2025.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// In-memory data holder
@Component
public class DataHolder {

    public static List<Category> categories = null;

    // On application startup, initialize the categories list
    // On each startup, the list will be initialized with the same values and the previous values will be lost

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();

        categories.add(new Category("Movies", "Movies Category"));
        categories.add(new Category("Books", "Books Category"));
    }
}

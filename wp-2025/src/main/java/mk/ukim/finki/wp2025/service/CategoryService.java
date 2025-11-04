package mk.ukim.finki.wp2025.service;

import mk.ukim.finki.wp2025.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> listCategories();

    Optional<Category> findById(Long id);

    Category create(String name, String description);

    Category update(String name, String description);

    void delete(String name);

    List<Category> searchCategories(String text);
}

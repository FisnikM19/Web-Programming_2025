package mk.ukim.finki.wp2025.service;

import mk.ukim.finki.wp2025.model.Product;
import mk.ukim.finki.wp2025.model.ProductLevel;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Product create(
            String name,
            Double price,
            Integer quantity,
            ProductLevel level,
            Long categoryId,
            Long manufacturerId
    );

    Product update(
            Long id,
            String name,
            Double price,
            Integer quantity,
            ProductLevel level,
            Long categoryId,
            Long manufacturerId
    );

    List<Product> findAll();

    List<Product> search(String text);

    void delete(Long id);
}

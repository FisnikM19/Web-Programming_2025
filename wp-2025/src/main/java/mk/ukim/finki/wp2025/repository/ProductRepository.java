package mk.ukim.finki.wp2025.repository;

import mk.ukim.finki.wp2025.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    List<Product> search(String text);

    void delete(Long id);
}

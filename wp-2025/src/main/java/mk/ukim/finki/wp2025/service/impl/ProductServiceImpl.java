package mk.ukim.finki.wp2025.service.impl;

import mk.ukim.finki.wp2025.model.Category;
import mk.ukim.finki.wp2025.model.Manufacturer;
import mk.ukim.finki.wp2025.model.Product;
import mk.ukim.finki.wp2025.model.ProductLevel;
import mk.ukim.finki.wp2025.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wp2025.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wp2025.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wp2025.repository.ProductRepository;
import mk.ukim.finki.wp2025.service.CategoryService;
import mk.ukim.finki.wp2025.service.ManufacturerService;
import mk.ukim.finki.wp2025.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ManufacturerService manufacturerService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId) {

        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Manufacturer manufacturer = manufacturerService.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));

        return productRepository.save(new Product(name, price, quantity, level, category, manufacturer));
    }

    @Override
    public Product update(Long id, String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId) {

        Product product = findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Manufacturer manufacturer = manufacturerService.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setLevel(level);
        product.setCategory(category);
        product.setManufacturer(manufacturer);

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> search(String text) {
        return productRepository.search(text);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }
}

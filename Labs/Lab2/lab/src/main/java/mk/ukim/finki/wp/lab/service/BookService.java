package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();

    Optional<Book> findById(Long id);

    List<Book> searchBooks(String text, Double rating);

    Book create(
            String title,
            String genre,
            Double averageRating,
            Long authorId
    );

    Book update(
            Long id,
            String title,
            String genre,
            Double averageRating,
            Long authorId
    );

    void delete(String name);

    void delete(Long id);
}

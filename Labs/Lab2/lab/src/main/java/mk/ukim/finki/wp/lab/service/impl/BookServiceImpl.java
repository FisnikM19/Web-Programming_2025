package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.wp.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book create(String title, String genre, Double averageRating, Long authorId) {
        if (title == null || title.isEmpty() || genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Author author = authorService
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = new Book(title, genre, averageRating, author);

        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String title, String genre, Double averageRating, Long authorId) {

        Book book = findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author = authorService
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        if (text == null || text.isEmpty() || rating == null || rating.isNaN()) {
            throw new IllegalArgumentException();
        }

        return this.bookRepository.searchBooks(text, rating);
    }

    @Override
    public void delete(String name) {
        this.bookRepository.delete(name);
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(id);
    }
}

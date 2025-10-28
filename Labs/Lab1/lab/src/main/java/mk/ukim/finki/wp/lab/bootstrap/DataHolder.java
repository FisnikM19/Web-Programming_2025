package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// In-memory data holder
@Component
public class DataHolder {

    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;

    // On application startup, initialize the in-memory lists with predefined data
    // On each startup, the lists will be initialized with the same values and the previous values will be lost
    @PostConstruct
    public void init() {
       books = new ArrayList<>();
       reservations = new ArrayList<>();

        books.add(new Book("The Silent Patient", "Thriller", 4.2));
        books.add(new Book("Atomic Habits", "Self-Help", 4.8));
        books.add(new Book("Dune", "Science Fiction", 4.6));
        books.add(new Book("Pride and Prejudice", "Romance",  4.5));
        books.add(new Book("The Hobbit", "Fantasy", 4.7));
        books.add(new Book("To Kill a Mockingbird", "Classic", 4.9));
        books.add(new Book("1984", "Dystopian",  4.8));
        books.add(new Book("The Girl on the Train", "Mystery",4.1));
        books.add(new Book("The Alchemist", "Adventure", 4.3));
        books.add(new Book("Educated", "Biography", 4.6));

    }

}

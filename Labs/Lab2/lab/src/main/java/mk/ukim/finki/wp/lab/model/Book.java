package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
    private Long id;
    private Author author;

    public Book(String title, String genre, double averageRating, Author author) {
        this.id = (long) (Math.random() * 1000);
        this.averageRating = averageRating;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
}

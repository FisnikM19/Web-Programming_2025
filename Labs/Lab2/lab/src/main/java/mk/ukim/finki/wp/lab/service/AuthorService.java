package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    public List<Author> findAll();

    void delete(Long id);

    //TODO:
    Author create(
            String name,
            String surname,
            String country,
            String biography
    );

    Author update(
            Long id,
            String name,
            String surname,
            String country,
            String biography
    );

}

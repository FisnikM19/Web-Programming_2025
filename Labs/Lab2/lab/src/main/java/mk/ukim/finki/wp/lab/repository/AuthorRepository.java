package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> findById(Long id);

    public List<Author> findAll();

    void delete(Long id);

    //TODO:
    Author save(Author author);
}

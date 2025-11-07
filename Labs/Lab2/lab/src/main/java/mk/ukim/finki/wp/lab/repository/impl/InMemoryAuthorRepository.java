package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {

    @Override
    public Optional<Author> findById(Long id) {
        return DataHolder.authors.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public void delete(Long id) {
        DataHolder.authors.removeIf(a -> a.getId().equals(id));
    }
}

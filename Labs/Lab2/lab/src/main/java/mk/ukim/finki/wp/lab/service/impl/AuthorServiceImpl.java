package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.delete(id);
    }

    //TODO:

    @Override
    public Author create(String name, String surname, String country, String biography) {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() ||
        country == null || country.isEmpty() || biography == null || biography.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Author author = new Author(name, surname, country, biography);

        return this.authorRepository.save(author);
    }

    @Override
    public Author update(Long id, String name, String surname, String country, String biography) {
        Author author = findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        author.setBiography(biography);

        return authorRepository.save(author);
    }
    //TODO:DONE
}

package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
   private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String getAuthorsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Author> authors = authorService.findAll();

        model.addAttribute("authors", authors);
        return "listAuthors";
    }

    @PostMapping("/authors/add")
    public String saveAuthor(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String country,
                           @RequestParam String biography
    ) {
        authorService.create(name, surname, country, biography);
        return "redirect:/authors";
    }

    @GetMapping("edit/{authorId}")
    public String getEditAuthor(@RequestParam long id, Model model) {
        Author a = authorService.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        model.addAttribute("author", a);
        return "author-form";

    }

    @PostMapping("authors/edit/{authorId}")
    public String editAuthor(@PathVariable Long authorId,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String country,
                           @RequestParam String biography)
    {
        authorService.update(authorId, name, surname, country, biography);
        return "redirect:/authors";
    }

    @PostMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/authors/author-form/{id}")
    public String getEditAuthorForm(@PathVariable Long id, Model model) {
        Author author = authorService.findById(id).orElse(null);
        if (author == null) {
            return "redirect:/authors?error=AuthorNotFound";
        }
        model.addAttribute("author", author);
        model.addAttribute("authors", authorService.findAll());
        return "author-form";
    }

    @GetMapping("/authors/author-form")
    public String getAddAuthorPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author-form";
    }
}

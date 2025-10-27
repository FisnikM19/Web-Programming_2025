package mk.ukim.finki.wp2025.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    // in-memory list of categories
    private List<Category> categories = null;

    public CategoryServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    /**
     * We those @Getter, @Setter, @AllArgsConstructor
     * We have constructor, getters and setters behind the scene created!
     */

    @Getter
    @Setter
    @AllArgsConstructor
    class Category {
        private String name;
        private String description;
    }

    private void addCategory(String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            return;
        }

        Category category = new Category(name, description); // even though we don't initialize constructor by code, we have it because of @AllArgsConstructor

        categories.add(category);
    }

    // initialize the categories
    @Override
    public void init() throws ServletException {
        categories = new ArrayList<>();

        addCategory("Movies", "Movies category");
        addCategory("Books", "Books category");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("userAgent", req.getHeader("user-agent"));
        context.setVariable("categories", categories);

        springTemplateEngine.process("categories.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        addCategory(name, description);

        resp.sendRedirect("/servlet/category");
    }
}

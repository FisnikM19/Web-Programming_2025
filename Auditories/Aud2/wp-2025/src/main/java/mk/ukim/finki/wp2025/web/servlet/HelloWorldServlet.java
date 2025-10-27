package mk.ukim.finki.wp2025.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/** with those url patterns we can redirect to the home page,
 * for example: 1. localhost:9090
 *              2. localhost:9090/hello
 *              3. localhost:9090/fisnik
 * the reason why 9090, because at the /templates/application.properties we have changed the server.port to 9090
*/
@WebServlet(name = "HelloWorldServlet", urlPatterns = {"", "/hello", "/fisnik"})
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // initialize the writer
        PrintWriter writer = resp.getWriter();

        // get the name and surname parameters from the request
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (name == null) {
            name = "X";
        }

        if (surname == null) {
            surname = "Y";
        }

        // write the response
        writer.format("<html><head></head><body><h1>Hello %s %s</h1></body></html>", name, surname);

        // flush the writer
        writer.flush();

    }
}

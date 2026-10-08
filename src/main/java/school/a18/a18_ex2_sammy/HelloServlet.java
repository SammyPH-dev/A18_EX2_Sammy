package school.a18.a18_ex2_sammy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        try {
            System.out.println("========List de fichier============");
            Files.list(Paths.get(".")).forEach(p -> System.out.println(p.getFileName()));
            System.out.println("=======fin============");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
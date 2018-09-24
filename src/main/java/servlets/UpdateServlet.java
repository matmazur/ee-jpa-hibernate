package servlets;

import dao.BookDao;
import model.Book;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Inject
    BookDao dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("name");
            String author = req.getParameter("author");

            if (!(isbn.trim().isEmpty() || title.trim().isEmpty() || author.trim().isEmpty())) {

                Book book = new Book();
                book.setId(id);
                book.setAuthor(author);
                book.setIsbn(isbn);
                book.setTitle(title);

                dao.update(book);
                resp.sendRedirect("success.jsp");
            } else {
                resp.sendRedirect("failure.jsp");
            }

        } catch (Exception ignored) {
            resp.sendRedirect("failure.jsp");
        }

    }
}

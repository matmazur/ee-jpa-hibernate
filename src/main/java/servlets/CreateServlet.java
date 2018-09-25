package servlets;

import dao.BookDao;
import dao.BookDetailsDAO;
import model.Book;
import model.BookDetails;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    @Inject
    BookDao dao;
    @Inject
    BookDetailsDAO detailsDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try {
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("name");
            String author = req.getParameter("author");
            String description = req.getParameter("description");
            Double price = Double.valueOf(req.getParameter("price"));
            Integer year = Integer.valueOf(req.getParameter("year"));


            if (!(isbn.trim().isEmpty() || title.trim().isEmpty() || author.trim().isEmpty())) {

                Book book = new Book(isbn, title, author);
                BookDetails details  = new BookDetails(description,price,year);
                book.setBookDetails(details);

                detailsDAO.create(details);
                dao.create(book);
                resp.sendRedirect("success.jsp");
            } else {
                resp.sendRedirect("failure.jsp");
            }

        } catch (Exception ignored) {
            resp.sendRedirect("failure.jsp");
        }

    }
}

package servlets;

import dao.BookDao;
import model.Book;

import javax.inject.Inject;
import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    @Inject
    BookDao dao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String option = req.getParameter("form");
        if (option.equals("add")){
            String isbn = req.getParameter("isbn");
            String author = req.getParameter("author");
            String title = req.getParameter("title");

            Book book = new Book();
            book.setAuthor(author);
            book.setIsbn(isbn);
            book.setTitle(title);

            dao.save(book);
        }
        if (option.equals("jpql")){

            String query = req.getParameter("query");
            List<Book> books = dao.doQuery(query);

            for(Book b:books) {
                resp.getWriter().println(b);
            }

        }
    }
}

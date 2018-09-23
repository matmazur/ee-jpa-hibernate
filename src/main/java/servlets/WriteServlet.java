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


@WebServlet("/write")
public class WriteServlet extends HttpServlet {

    @Inject
    BookDao dao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("name");
            String author = req.getParameter("author");


            Book book = new Book(isbn, title, author);

            dao.save(book);
            resp.sendRedirect("success.jsp");


        }catch (Exception e){
            resp.sendRedirect("failure.jsp");
        }
    }
}


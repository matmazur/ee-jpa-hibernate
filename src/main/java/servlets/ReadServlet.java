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


@WebServlet("/read")
public class ReadServlet extends HttpServlet {


    @Inject
    BookDao dao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long id = (Long) req.getAttribute("id");
        Book book = dao.get(id);

        resp.getWriter().println(book);

    }
}

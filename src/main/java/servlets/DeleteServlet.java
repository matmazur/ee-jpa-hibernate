package servlets;

import dao.BookDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Inject
    BookDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.valueOf(req.getParameter("id"));
            dao.delete(id);
            resp.sendRedirect("success.jsp");
        } catch (Exception ignored) {
            resp.sendRedirect("failure.jsp");
        }
    }
}


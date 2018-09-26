package servlets;

import dao.UserDAO;
import model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-client")
public class GetClient extends HttpServlet {

    @Inject
    UserDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("clientId"));

        User user = dao.read(id);

        resp.getWriter().println(user);

    }
}
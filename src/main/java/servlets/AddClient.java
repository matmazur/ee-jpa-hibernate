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

@WebServlet("/add-client")
public class AddClient extends HttpServlet {

    @Inject
    UserDAO dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("firstName");
        String surname = req.getParameter("lastName");
        String address = req.getParameter("address");


        User user = new User();
        user.setAddress(address);
        user.setName(name);
        user.setSurname(surname);

        dao.create(user);

    }
}


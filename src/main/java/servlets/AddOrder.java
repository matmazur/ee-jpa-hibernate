package servlets;

import dao.OrderDAO;
import dao.UserDAO;
import model.Order;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-order")
public class AddOrder extends HttpServlet {

    @Inject
    OrderDAO dao;

    @Inject
    UserDAO userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order order = new Order();

        Long clientId = Long.valueOf(req.getParameter("clientId"));
        String orderDetails = req.getParameter("orderDetails");

        order.setOrderDetails(orderDetails);
        order.setUser(userDao.read(clientId));

        dao.create(order);

        resp.sendRedirect(getServletContext().getContextPath());
    }
}

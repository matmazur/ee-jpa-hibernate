package servlets;

import dao.OrderDAO;
import dao.UserDao;
import dao.UserDaoImpl;
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
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long clientId = Long.valueOf(req.getParameter("clientId"));
        String productName = req.getParameter("productName");
        String orderDetails = req.getParameter("orderDetails");

        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setUser(userDao.read(clientId));

        dao.create(order);
    }
}

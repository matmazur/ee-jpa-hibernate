package servlets;


import dao.OrderDAO;
import model.Order;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-order")
public class GetOrder extends HttpServlet {

    @Inject
    OrderDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("orderId"));

        Order order = dao.read(id);

        resp.getWriter().println(order + " User id: " + order.getUser().getId());
    }
}
package servlets;

import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-product-order")
public class AddProductOrder extends HttpServlet {

    @Inject
    OrderDAO orderDAO;
    @Inject
    ProductDAO productDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long orderId = Long.valueOf(req.getParameter("orderId"));
        Long productId = Long.valueOf(req.getParameter("productId"));

        Order order = orderDAO.read(orderId);
        Product product = productDAO.read(productId);

        order.getProducts().add(product);

        resp.sendRedirect(getServletContext().getContextPath());
    }
}

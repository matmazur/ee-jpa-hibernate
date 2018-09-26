package servlets;

import dao.ProductDAO;
import model.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-product")
public class AddProduct extends HttpServlet {

    @Inject
    ProductDAO dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

        String productName = req.getParameter("productName");
        Double productPrice = Double.valueOf(req.getParameter("productPrice"));
        String productDetails = req.getParameter("productDetails");

        product.setDetails(productDetails);
        product.setName(productName);
        product.setPrice(productPrice);

        dao.create(product);

        resp.sendRedirect(getServletContext().getContextPath());
    }
}

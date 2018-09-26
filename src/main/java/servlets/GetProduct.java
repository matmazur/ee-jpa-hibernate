package servlets;

import dao.ProductDAO;
import dao.UserDAO;
import model.Product;
import model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-product")
public class GetProduct extends HttpServlet {

    @Inject
    ProductDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("productId"));

        Product product = dao.read(id);

        resp.getWriter().println(product);

    }
}
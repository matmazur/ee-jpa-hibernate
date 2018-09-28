package Main;

import dao.BookDao;
import dao.BookDaoImpl;
import model.Book;
import model.City;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String password = "pass";

        System.out.println("Connecting to the DB + " + jdbcUrl);

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
// THIS ABOVE WORKS CORRECLTY  -  CONNECTION TO THE DB IS PROPER

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("worldUnit");
        EntityManager entity = factory.createEntityManager();


        Query query = entity.createQuery("SELECT c FROM City c where c.countryCode='POL'");
        List<City> cities = query.getResultList();
        for(City c:cities){
            System.out.println(c);
        }
        City city = entity.find(City.class,1L);
        System.out.println(city);

    }
}

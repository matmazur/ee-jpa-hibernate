package Main;

import dao.BookDao;
import dao.BookDaoImpl;
import model.Book;
import model.City;

import javax.persistence.*;
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

// FACTORY AND ENTITY CREATED - DON'T TOUCH

        TypedQuery<City> query = entity.createQuery("SELECT c FROM City c where c.countryCode='POL'", City.class);
        List<City> cities = query.getResultList();
        for (City c : cities) {
            System.out.println(c);
        }


        Query queryDelete = entity.createQuery("DELETE FROM City c WHERE c.countryCode='BOL'");
        entity.getTransaction().begin();
        queryDelete.executeUpdate();
        entity.getTransaction().commit();

        Query queryAddPopulation = entity.createQuery("UPDATE City c SET c.population=c.population+1000 where c.countryCode='POL'");
        entity.getTransaction().begin();
        queryAddPopulation.executeUpdate();
        entity.getTransaction().commit();

        query = entity.createQuery("SELECT c FROM City c where c.countryCode='POL'", City.class);
        cities = query.getResultList();
        for (City c : cities) {
            System.out.println(c);
        }

        Query query2 = entity.createQuery("SELECT c FROM City c where c.id=1");
        System.out.println(query2.getSingleResult());

    }
}

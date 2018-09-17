package dao;

import model.Book;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;

@RequestScoped
public class BookDaoImpl implements BookDao {


    @PersistenceUnit(name = "persistanceUnit")
    private EntityManagerFactory factory;


    @Override
    public void save(Book book) {

        EntityManager en = factory.createEntityManager();
        EntityTransaction tran = en.getTransaction();
        tran.begin();
        en.persist(book);
        tran.commit();
        en.close();
    }

    @Override
    public Book get(Long id) {

        EntityManager en = factory.createEntityManager();
        en.close();

        return en.find(Book.class, id);
    }


}

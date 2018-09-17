package dao;

import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {


    private EntityManagerFactory factory;
    private EntityManager en;


    public BookDaoImpl() {
        factory = Persistence.createEntityManagerFactory("TestPersistence");
        en = factory.createEntityManager();
    }


    @Override
    public void save(Book book) {

        EntityTransaction tran = en.getTransaction();
        tran.begin();
        en.persist(book);
        tran.commit();
    }

    @Override
    public Book get(Long id) {
        return en.find(Book.class, id);
    }

    @Override
    public void cleanUp() {

        en.close();
        factory.close();

    }
}

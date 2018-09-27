package dao;

import model.Book;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;

@RequestScoped
public class BookDaoImpl implements BookDao {


    private EntityManager entity;

    public BookDaoImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookPersistence");
        entity = factory.createEntityManager();
    }

    @Override
    public void save(Book book) {

        entity.getTransaction().begin();
        entity.persist(book);
        entity.getTransaction().commit();
    }

    @Override
    public Book get(Long id) {


        return entity.find(Book.class, id);
    }


    @Override
    public void close(){
        entity.close();
    }


}

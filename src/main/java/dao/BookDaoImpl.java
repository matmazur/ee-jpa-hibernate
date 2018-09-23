package dao;

import model.Book;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.*;

@Stateless
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Long save(Book book) {

        entityManager.persist(book);
        return book.getId();
    }

    @Override
    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }


}

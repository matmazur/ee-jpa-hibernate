package dao;

import model.Book;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;

@RequestScoped
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

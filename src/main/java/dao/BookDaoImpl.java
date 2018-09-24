package dao;

import model.Book;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.transaction.Transactional;

@RequestScoped
public class BookDaoImpl implements BookDao {

    @PersistenceContext(name = "bookPersistence")
    private EntityManager entityManager;

    @Transactional
    @Override
    public Long create(Book book) {
       entityManager.persist(book);
       return book.getId();
    }

    @Override
    public Book read(Long id) {
        return entityManager.find(Book.class,id);
    }

    @Override
    public Long update(Long id) {
        return entityManager.;
    }

    @Override
    public void delete(Long id) {


        entityManager.remove(entityManager.find(Book.class,id));

    }
}

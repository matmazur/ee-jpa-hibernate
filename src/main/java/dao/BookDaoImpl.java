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
        return entityManager.find(Book.class, id);
    }

    @Transactional
    @Override
    public Long update(Book book) {

//        Book bookFromDB = entityManager.find(Book.class, book.getId());
//        bookFromDB.setTitle(book.getTitle());
//        bookFromDB.setIsbn(book.getIsbn());
//        bookFromDB.setAuthor(book.getAuthor());
        
        entityManager.merge(book);
        return book.getId();
    }

    @Transactional
    @Override
    public void delete(Long id) {

        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);

    }
}

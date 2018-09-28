package dao;

import model.Book;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class BookDaoImpl implements BookDao {

    @PersistenceContext(unitName = "storePersistence")
    private EntityManager entity;

    @Override
    public void save(Book book) {
        entity.persist(book);
    }

    @Override
    public Book get(Long id) {
        return entity.find(Book.class, id);
    }

    @Override
    public void close() {
        entity.close();
    }

    @Override
    public List<Book> findAll() {
        return entity.createNamedQuery("Book.findAll").getResultList();
    }

    @Override
    public List<Book> findAllOrderedByAuthor() {
        return entity.createNamedQuery("Book.findAllOrderByAuthor").getResultList();
    }

    @Override
    public List<Book> doQuery(String query) {
        TypedQuery<Book> actualQuery = entity.createQuery(query, Book.class);
        return actualQuery.getResultList();
    }
}

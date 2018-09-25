package dao;

import model.BookDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class BookDetailsDaoImpl implements BookDetailsDAO {

    @PersistenceContext(name = "bookPersistence")
    private EntityManager entityManager;

    @Transactional
    @Override
    public Long create(BookDetails bookDetails) {
        entityManager.persist(bookDetails);
        return bookDetails.getId();
    }

    @Override
    public BookDetails read(Long id) {
        return entityManager.find(BookDetails.class,id);
    }

    @Transactional
    @Override
    public Long update(BookDetails bookDetails) {

        entityManager.merge(bookDetails);

        return bookDetails.getId();
    }

    @Override
    public void delete(Long id) {

        entityManager.remove(entityManager.find(BookDetails.class,id));
    }
}

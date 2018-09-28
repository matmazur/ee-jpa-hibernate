package dao;

import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext(unitName  = "storePersistence")
    EntityManager entityManager;

    @Override
    public Long create(Product product) {

        entityManager.persist(product);
        return product.getId();
    }

    @Override
    public Product read(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Long update(Product product) {
        entityManager.merge(product);
        return product.getId();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }
}

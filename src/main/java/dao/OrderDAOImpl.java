package dao;

import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderDAOImpl implements OrderDAO{


    @PersistenceContext(name = "bookPersistence")
    private EntityManager entityManager;


    @Override
    public Long create(Order order) {
        entityManager.persist(order);
        return order.getId();
    }

    @Override
    public Order read(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public Long update(Order order) {

        entityManager.merge(order);

        return order.getId();
    }

    @Override
    public void delete(Long id) {

        entityManager.remove(entityManager.find(Order.class, id));
    }
}

package dao;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

@Stateless
public class UserDaoImpl implements UserDao {

    @PersistenceContext(name = "bookPersistence")
    private EntityManager entityManager;


    @Override
    public Long create(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    @Override
    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Long update(User user) {

        entityManager.merge(user);

        return user.getId();
    }

    @Override
    public void delete(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }
}

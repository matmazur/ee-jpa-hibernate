package dao;


import model.User;

public interface UserDao {
    Long create(User user);

    model.User read(Long id);

    Long update(User user);

    void delete(Long id);

}

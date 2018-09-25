package dao;


import javax.xml.registry.infomodel.User;

public interface UserDao {
    Long create(User user);

    User read(Long id);

    Long update(User user);

    void delete(Long id);

}

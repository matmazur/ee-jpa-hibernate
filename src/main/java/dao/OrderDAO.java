package dao;

import model.Order;

public interface OrderDAO {

    Long create(Order order);

    Order read(Long id);

    Long update(Order order);

    void delete(Long id);

}

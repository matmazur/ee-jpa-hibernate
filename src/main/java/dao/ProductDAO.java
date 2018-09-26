package dao;

import model.Product;

public interface ProductDAO {


    Long create(Product product);

    Product read(Long id);

    Long update(Product product);

    void delete(Long id);


}

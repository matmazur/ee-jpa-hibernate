package dao;

import model.Book;

public interface BookDao {
    Long create(Book book);

    Book read(Long id);

    Long update(Long id);

    void delete(Long id);

}
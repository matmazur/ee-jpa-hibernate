package dao;

import model.Book;

public interface BookDao {
    Long create(Book book);

    Book read(Long id);

    Long update(Book book);

    void delete(Long id);

}
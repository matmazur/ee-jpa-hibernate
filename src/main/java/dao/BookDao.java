package dao;

import model.Book;

public interface BookDao {
    Long create(Book book);

    Book read(Long id);

    Book update(Long id);

    Long delete(Long id);

}
package dao;

import model.Book;

public interface BookDao {
    public Long save(Book book);

    public Book get(Long id);

}
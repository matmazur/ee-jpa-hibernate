package dao;

import model.Book;
import java.util.List;

public interface BookDao {
    public void save(Book book);

    public Book get(Long id);

    public void close();

    public List<Book> doQuery(String query);
}
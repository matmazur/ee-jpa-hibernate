package dao;

import model.BookDetails;

public interface BookDetailsDAO {
    Long create(BookDetails bookDetails);

    BookDetails read(Long id);

    Long update(BookDetails bookDetails);

    void delete(Long id);

}
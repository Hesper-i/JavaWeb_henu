package daoInt;

import book.Book;

import java.sql.SQLException;
import java.util.List;

public interface ImplBookDao {
    public void saveBook(Book book) throws SQLException, ClassNotFoundException;

    public List<Book> findAll() throws SQLException, ClassNotFoundException;

    public int delete(String bookName) throws SQLException, ClassNotFoundException;

    public int update(int newBookStock, String bookName) throws SQLException, ClassNotFoundException;
}

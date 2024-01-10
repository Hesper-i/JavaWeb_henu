package service;

import dao.BookDaoMysql;
import pojo.Book;

import java.util.List;

public class BookService {
    private BookDaoMysql bookDaoMysql = new BookDaoMysql();

    public List<Book> selectAll() {

        //查询结果
        List<Book> books = bookDaoMysql.queryAllBooks();
        return books;
    }

    public Book selectById(Integer id) {

        //查询结果
        Book book = bookDaoMysql.queryBookByID(id);

        return book;
    }

    public boolean add(Book book)
    {
        //添加新书
        boolean res = bookDaoMysql.saveBook(book);
        return res;
    }

    public boolean updateById(Book book)
    {
        //更新新书
        boolean res = bookDaoMysql.updateBook(book);
        return res;
    }

    public boolean deleteById(Integer id)
    {
        boolean res = bookDaoMysql.deleteBook(id);
        return res;
    }
}

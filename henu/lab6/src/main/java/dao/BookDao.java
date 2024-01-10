package dao;
import java.util.ArrayList;
import pojo.Book;

public interface BookDao {
	public boolean saveBook(Book bk);
	public boolean updateBook(Book bk);
	public boolean deleteBook(Integer id);
	public Book queryBookByID(Integer id);
	public ArrayList<Book> queryAllBooks();
}

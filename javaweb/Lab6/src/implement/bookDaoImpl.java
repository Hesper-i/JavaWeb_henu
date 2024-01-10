package implement;

import book.Book;
import daoInt.ImplBookDao;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookDaoImpl implements ImplBookDao {

    @Override
    public void saveBook(Book book) throws SQLException, ClassNotFoundException {
        String sql = "insert into book_lab(name, price, author, publisher, stock) values(?, ?, ?, ?, ?)";
        Connection con = DBConnection.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, book.getname());
        pstmt.setFloat(2, book.getPrice());
        pstmt.setString(3, book.getauthor());
        pstmt.setString(4, book.getPublisher());
        pstmt.setInt(5, book.getStock());

        pstmt.executeUpdate();
    }

    @Override
    public List<Book> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from book_lab";
        Connection con = DBConnection.openConnection();
        Statement stmt = con.createStatement();

        List<Book> list = new ArrayList<Book>();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            Book b = new Book();
            b.setname(rs.getString("name"));
            b.setPrice(rs.getFloat("price"));
            b.setauthor(rs.getString("author"));
            b.setPublisher(rs.getString("publisher"));
            b.setStock(rs.getInt("stock"));
            list.add(b);
        }

        return list;
    }

    @Override
    public int delete(String name) throws SQLException, ClassNotFoundException {
        String sql = "delete from book_lab where name=?";
        Connection con = DBConnection.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        int result = 0;

        pstmt.setString(1, name);
        result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public int update(int newBookStock, String name) throws SQLException, ClassNotFoundException {
        String sql = "update book_lab set stock=? where name=?";
        Connection con = DBConnection.openConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        int result = 0;

        pstmt.setInt(1, newBookStock);
        pstmt.setString(2, name);
        result = pstmt.executeUpdate();

        return result;
    }
}

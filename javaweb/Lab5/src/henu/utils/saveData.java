package henu.utils;

import book.BookBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class saveData {
    public static void saveBook(BookBean book) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.openConnection();
        String sql = "insert into book_lab values(?, ?, ?, ?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getName());
        pstmt.setFloat(2, book.getPrice());
        pstmt.setString(3, book.getAuthor());
        pstmt.setString(4, book.getPublisher());
        pstmt.setInt(5,book.getStock());

        pstmt.executeUpdate();
    }
}

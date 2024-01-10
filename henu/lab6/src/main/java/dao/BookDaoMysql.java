package dao;

import java.sql.*;
import java.util.ArrayList;

import dao.BookDao;
import util.DBConnection;
import pojo.Book;

public class BookDaoMysql implements BookDao
{

	@Override
	public boolean saveBook(Book bk) {
		boolean result=false;
		
		try {
			Connection con=DBConnection.openConnection();
			String sql="insert into tb_book values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setNull(1, Types.INTEGER);
			pstmt.setString(2, bk.getName());
			pstmt.setDouble(3, bk.getPrice());
			pstmt.setString(4, bk.getAuthor());
			pstmt.setString(5, bk.getPublisher());
			pstmt.setInt(6, bk.getAmount());
			int count=pstmt.executeUpdate();
			if (count>0) {
				result=true;
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean updateBook(Book bk) {
		boolean result=false;

		try {
			Connection con=DBConnection.openConnection();
			String sql="update tb_book set book_name = ? , book_price = ?, book_author = ?, book_publisher = ?, book_amount = ? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bk.getName());
			pstmt.setDouble(2, bk.getPrice());
			pstmt.setString(3, bk.getAuthor());
			pstmt.setString(4, bk.getPublisher());
			pstmt.setInt(5, bk.getAmount());
			pstmt.setInt(6, bk.getId());

			int count=pstmt.executeUpdate();
			if (count>0) {
				result=true;
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean deleteBook(Integer id) {
		boolean result=false;
		
		try {
			Connection con=DBConnection.openConnection();
			String sql="delete from tb_book where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int count=pstmt.executeUpdate();
			if (count>0) {
				result=true;
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Book queryBookByID(Integer id) {
		Book book = new Book();
		try {
			Connection con=DBConnection.openConnection();
			String sql="select * from tb_book where id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next())
			{
				//设置book
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setAmount(rs.getInt("book_amount"));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public ArrayList<Book> queryAllBooks() {
		ArrayList<Book> books=new ArrayList<Book>();
		
		try {
			Connection con=DBConnection.openConnection();
			String sql="select * from tb_book";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				String author=rs.getString(4);
				String publisher=rs.getString(5);
				int amount = rs.getInt(6);
				Book bk = new Book();
				bk.setId(id);
				bk.setName(name);
				bk.setAuthor(author);
				bk.setPublisher(publisher);
				bk.setPrice(price);
				bk.setAmount(amount);
				books.add(bk);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return books;
	}
	
}

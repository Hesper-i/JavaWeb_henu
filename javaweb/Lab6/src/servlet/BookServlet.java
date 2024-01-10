package servlet;

import book.Book;
import daoInt.ImplBookDao;
import factory.bookDaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        ImplBookDao ibd = bookDaoFactory.getInterfaceFactory();  // 获取DAO实现接口

        switch(operation){
            case "show":{
                List<Book> list = null;
                try {
                    list = ibd.findAll();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("list", list);
                request.getRequestDispatcher("showBook.jsp").forward(request, response);
                break;
            }
            case "add":{
                String name = request.getParameter("name");
                float price =(!request.getParameter("price").equals("")) ? Float.parseFloat(request.getParameter("price")) : 0;
                String author = request.getParameter("author");
                String publisher = request.getParameter("publisher");
                int stock=(!request.getParameter("stock").equals("")) ? Integer.parseInt(request.getParameter("stock")) : 0;

                Book book = new Book();
                book.setname(name);
                book.setPrice(price);
                book.setauthor(author);
                book.setPublisher(publisher);
                book.setStock(stock);

                try {
                    ibd.saveBook(book);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("index.jsp");
                break;
            }
            case "delete":{
                String name = request.getParameter("name");
                try {
                    ibd.delete(name);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("index.jsp");
                break;
            }
            case "update":{
                String name = request.getParameter("name");
                int newStock = Integer.parseInt(request.getParameter("newBookNum"));

                try {
                    ibd.update(newStock, name);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("index.jsp");
                break;
            }
            default:{

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

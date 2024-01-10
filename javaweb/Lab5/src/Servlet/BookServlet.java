package Servlet;

import book.BookBean;

import henu.utils.saveData;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("bookname");
        float price =(!request.getParameter("price").equals("")) ? Float.parseFloat(request.getParameter("price")) : 0;
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int stock=(!request.getParameter("stock").equals("")) ? Integer.parseInt(request.getParameter("stock")) : 0;

        BookBean book = new BookBean();
        book.setPrice(price);
        book.setName(name);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setStock(stock);
        try {
            saveData.saveBook(book);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("book", book);
        request.getRequestDispatcher("show.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

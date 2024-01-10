package web;

import pojo.Book;
import service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取BookService对象
        BookService bookService = new BookService();

        //获取Books数据
        List<Book> books = bookService.selectAll();

        //输出Books数据
        for(Book book : books)
        {
            System.out.println(book);
        }

        //封装到request域
        request.setAttribute("books", books);

        //转发到展示页面
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
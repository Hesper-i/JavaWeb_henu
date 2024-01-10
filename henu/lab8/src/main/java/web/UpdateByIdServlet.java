package web;

import pojo.Book;
import service.BookService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.io.IOException;

@WebServlet(value = "/updateByIdServlet")
public class UpdateByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取BookService对象
        BookService bookService = new BookService();

        //获取id
        String id = request.getParameter("id");
        System.out.println(id);
        Book book = bookService.selectById(Integer.parseInt(id));
        System.out.println(book);

        //获取amount
        String amount = request.getParameter("amount");
        System.out.println(amount);
        book.setAmount(Integer.parseInt(amount));

        //调用update方法
        bookService.updateById(book);
        //转发
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
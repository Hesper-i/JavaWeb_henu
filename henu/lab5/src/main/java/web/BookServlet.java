package web;

import pojo.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/bookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //获取book信息
        String bookname = request.getParameter("bookname");

        //double bookprice = Double.parseDouble(request.getParameter("bookprice"));
        //若没有传入值，自动赋值
        double bookprice = (!request.getParameter("bookprice").equals("")) ? Double.parseDouble(request.getParameter("bookprice")) : 0.0;

        String bookauthor = request.getParameter("bookauthor");
        String bookpublisher = request.getParameter("bookpublisher");

        //int bookamount = Integer.parseInt(request.getParameter("bookamount"));
        //若没有传入值，自动赋值
        int bookamount = (!request.getParameter("bookamount").equals("")) ? Integer.parseInt(request.getParameter("bookamount")) : 0;

        //创建book对象并封装信息
        Book book = new Book();
        book.setName(bookname);
        book.setPrice(bookprice);
        book.setAuthor(bookauthor);
        book.setPublisher(bookpublisher);
        book.setAmount(bookamount);

        //添加到request域中
        request.setAttribute("book", book);

        //转发显示
        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
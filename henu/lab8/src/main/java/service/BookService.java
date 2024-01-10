package service;

import mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Book;
import util.SqlSessionFactoryUtils;
import java.util.List;


public class BookService {

    //获取sqlSessionFactory对象
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Book> selectAll()
    {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        //执行selectAll
        List<Book> books = mapper.selectAll();

        //关闭
        sqlSession.close();

        return books;
    }

    public Book selectById(int id)
    {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        Book book = mapper.selectById(id);

        sqlSession.close();

        return book;
    }

    public void deleteById(int id)
    {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    public void updateById(Book book)
    {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.updateById(book);

        //提交事务！！！
        sqlSession.commit();

        sqlSession.close();
    }

    public void add(Book book)
    {
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.add(book);

        //提交事务！！！
        sqlSession.commit();
        sqlSession.close();
    }
}

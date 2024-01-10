package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Book;

import java.util.List;

public interface BookMapper {

    @Select("select * from tb_book")
    @ResultMap("BookResultMap")
    List<Book> selectAll();

    @Select("select * from tb_book where id = #{id}")
    @ResultMap("BookResultMap")
    Book selectById(int id);

    @Insert("insert into tb_book value (null, #{name}, #{price}, #{author}, #{publisher}, #{amount})")
    @ResultMap("BookResultMap")
    void add(Book book);

    @Update("update tb_book set book_name=#{name}, book_price=#{price}, book_author=#{author}, book_publisher=#{publisher}, book_amount=#{amount} where id=#{id}")
    @ResultMap("BookResultMap")
    void updateById(Book book);

    @Delete("delete from tb_book where id = #{id}")
    @ResultMap("BookResultMap")
    void deleteById(int id);
}

-- 创建图书表
drop table if exists tb_user;

CREATE TABLE tb_book(
	id int primary key auto_increment,
	book_name varchar(32),
	book_price double(5,2),
    book_author varchar(32),
    book_publisher varchar(32),
    book_amount int,

);

-- 添加数据
INSERT INTO tb_book value(null, "JSP程序设计", 29.00, "三洋科技", "人民邮电出版社", 6);
INSERT INTO tb_book value(null, "java web程序开发", 34.00, "张三", "人民邮电出版社", 5);
INSERT INTO tb_book value(null, "算法分析与设计", 45.00, "马天明", "人民邮电出版社", 5);

SELECT * FROM tb_book;

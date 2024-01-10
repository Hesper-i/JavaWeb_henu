-- 删除tb_user表
DROP TABLE IF EXISTS tb_user;
-- 创建tb_user表
CREATE TABLE tb_user(
    id int primary key auto_increment,
	username VARCHAR(20),
	password VARCHAR(32)
);

-- 添加数据
INSERT INTO tb_user VALUES(1,'zhangsan','123'),(2,'lisi','234');

SELECT * from tb_user;







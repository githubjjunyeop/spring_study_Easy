-- member(회원 table
CREATE TABLE member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null
)

-- SQL(CRUD), JDBC

SELECT * FROM member;

--INSERT 
INSERT INTO member (id, pass, name, age, email, phone) 
VALUES('admin', 'admin', '관리자', 40, 'bit@naver.com', '010-1111-1111');

-- UPDATE
UPDATE member set age =45, phone='010-1111-0000' WHERE ID ='admin';

-- DELETE
DELETE FROM member WHERE ID ='admin';
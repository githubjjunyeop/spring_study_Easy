-- member(회원 table
CREATE TABLE member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null,
	unique key(id)
);
-- unique 중복 허용 X
-- SQL(CRUD), JDBC

SELECT * FROM member1;

--INSERT 
INSERT INTO member1 (id, pass, name, age, email, phone) 
VALUES('admin', 'admin', '홍길동', 40, 'bit@naver.com', '010-1111-1111');

INSERT INTO member1 (id, pass, name, age, email, phone) 
VALUES('myapp', 'tyui', '유관순', 30, 'bit123@naver.com', '010-2222-2222');

INSERT INTO member1 (id, pass, name, age, email, phone) 
VALUES('qwer', 'ghjk', '김짱구', 18, 'bit233@naver.com', '010-3333-3333');

INSERT INTO member1 (id, pass, name, age, email, phone) 
VALUES('asdf', 'bnm', '호다닥', 20, 'bit111@naver.com', '010-4444-4444');

-- UPDATE
UPDATE member set age =45, phone='010-1111-0000' WHERE ID ='admin';

-- DELETE
DELETE FROM member WHERE ID ='admin';

DROP TABLE member1;

SELECT * FROM member1;

CREATE TABLE member1(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(100) not null,
	filename varchar(50),
	unique key(id)
);
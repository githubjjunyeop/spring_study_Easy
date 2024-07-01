DROP TABLE myboard;
	create table myboard(
	idx int not null auto_increment, 
	memID VARCHAR(20) NOT NULL,
	title varchar(100) not null, 
	content varchar(2000) not null, 
	writer varchar(30) not null, 
	indate datetime default now(), 
	count int default 0,
	primary key(idx) 
);
SELECT * FROM myboard;

insert into myboard(title,content,writer) 
values('게시판 연습','게시판 연습','관리자'); 
insert into myboard(title,content,writer) 
values('게시판 연습','게시판 연습','박매일'); 
insert into myboard(title,content,writer) 
values('게시판 연습','게시판 연습','선생님'); 
select * from myboard order by idx desc;

DROP TABLE mem_tbl;
CREATE TABLE mem_tbl(
	memIdx INT auto_increment,
	memID VARCHAR(20) NOT NULL,
	memPassword VARCHAR(20) NOT NULL,
	memName VARCHAR(20) NOT NULL,
	memAge INT,
	memGender VARCHAR(20),
	memEmail VARCHAR(50),
	memProfile VARCHAR(50),
	PRIMARY KEY(memIdx)
);

insert into mem_tbl(memIdx, memID, memPassword, memName, 
			memAge, memGender, memEmail, memProfile) 
values('게시판 연습','게시판 연습','관리자');

SELECT * FROM mem_tbl;
DELETE mem_tbl FROM mem_tbl WHERE memID = 'qwer';
SHOW TABLES LIKE 'mem_tbl';
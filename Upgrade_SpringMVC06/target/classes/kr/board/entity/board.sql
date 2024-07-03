-- BOARD --
DROP TABLE myboard;

create table myboard(
	idx int not null auto_increment, 
	memID VARCHAR(20) NOT NULL,
	title VARCHAR(100) not null, 
	content VARCHAR(2000) not null, 
	writer VARCHAR(30) not null, 
	indate datetime default now(), 
	count int default 0,
	primary key(idx) 
);


-- Member --
DROP TABLE mem_stbl;

CREATE TABLE mem_stbl(
	memIdx INT NOT NULL,
	memID VARCHAR(20) NOT NULL,
	memPassword VARCHAR(68) NOT NULL,
	memName VARCHAR(20) NOT NULL,
	memAge INT,
	memGender VARCHAR(20),
	memEmail VARCHAR(50),
	memProfile VARCHAR(50), 
	PRIMARY KEY(memID)
);



-- Auth --
DROP TABLE mem_auth;

CREATE TABLE mem_auth(
	no INT NOT NULL auto_increment, 
	memID VARCHAR(50) NOT NULL, 
	auth VARCHAR(50) NOT NULL, 
	PRIMARY KEY(no),
	CONSTRAINT fk_member_auth FOREIGN KEY(memID) REFERENCES mem_stbl(memID)
);



SELECT * FROM mem_stbl;
SELECT * FROM myboard;
SELECT * FROM mem_auth;

DELETE FROM mem_auth;
DELETE FROM mem_stbl;
DELETE FROM myboard;
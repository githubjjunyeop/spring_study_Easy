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



-- auth --
DROP TABLE mem_auth;

CREATE TABLE mem_auth(
	no INT NOT NULL auto_increment, 
	memID VARCHAR(50) NOT NULL, 
	auth VARCHAR(50) NOT NULL, 
	PRIMARY KEY(no),
	CONSTRAINT fk_member_auth FOREIGN KEY(memID) REFERENCES mem_stbl(memID)
);



private int memIdx;
private String memID;
private String memPassword;
private String memName;
private int memAge; // <-null, 0
private String memGender;
private String memEmail;
private String memProfile; //사진정보
private List<AuthVO> authList;



SELECT * FROM mem_stbl;
SELECT * FROM myboard;
SELECT * FROM mem_auth;
DROP TABLE tb_board;

CREATE TABLE tb_board(
	idx INT not null auto_increment, -- 자동증가 (아이디)
	title VARCHAR(100) NOT NULL, -- 제목
	contents VARCHAR(4000) NOT NULL, -- 내용
	count INT, -- 조회수
	writer VARCHAR(30) NOT NULL, -- 등록자
	indate datetime default now() NOT NULL, -- 등록일
	PRIMARY KEY(idx)
);


select * from tb_board;

INSERT INTO tb_board(title, contents, count, writer)
VALUES('게시판 만들기', '게시판 만들기', 0, '관리자');
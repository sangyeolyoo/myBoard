/**
  데이터 베이스 생성 스크립트 입력
 */
CREATE TABLE Board (
	bno INT IDENTITY(1,1) NOT NULL,	
    title VARCHAR(50),
    contents VARCHAR(1000),
    author VARCHAR(20),
    regdate DATE,
    delcheck VARCHAR(1) DEFAULT 'N', 
    readcnt INT DEFAULT 0 NOT NULL,
    startIndex INT,
    cntPerPage INT
);

CREATE TABLE Comment(
	c_idx INT IDENTITY(1,1) NOT NULL,	
    b_idx INT NOT NULL,
	contents VARCHAR(100),
	author VARCHAR(10)
);

create table Files(
	fno int not null identity(1,1) primary key,
	bno int not null,
	filename varchar(200) not null,
	fileoriname varchar(300) not null,
	fileurl varchar(500) not null
);

INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트1', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트2', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트3', '내용', '작성자3', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트4', '내용', '작성자4', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트5', '내용', '작성자5', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트6', '내용', '작성자6', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트7', '내용', '작성자7', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트8', '내용', '작성자8', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트9', '내용', '작성자9', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트10', '내용', '작성자10', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트11', '내용', '작성자11', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트12', '내용', '작성자12', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트13', '내용', '작성자13', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트14', '내용', '작성자14', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트15', '내용', '작성자15', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트16', '내용', '작성자16', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트17', '내용', '작성자17', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트18', '내용', '작성자18', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트19', '내용', '작성자19', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트20', '내용', '작성자20', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트21', '내용', '작성자21', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트22', '내용', '작성자22', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트23', '내용', '작성자23', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트24', '내용', '작성자24', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트25', '내용', '작성자25', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트26', '내용', '작성자26', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트27', '내용', '작성자27', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트28', '내용', '작성자28', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트29', '내용', '작성자29', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트30', '내용', '작성자30', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트31', '내용', '작성자31', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트32', '내용', '작성자32', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트33', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트34', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트35', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트36', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트37', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트38', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트39', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트40', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트41', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트42', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트43', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트44', '내용', '검색', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트45', '내용', '작성자45', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트46', '내용', '작성자46', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트47', '내용', '작성자47', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트48', '내용', '작성자48', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트49', '내용', '작성자49', GetDate());
INSERT INTO board (title, contents, author, regdate)
VALUES ( '페이징테스트50', '내용', '작성자50', GetDate());
	
	
	
INSERT INTO comment (c_idx, b_idx, contents, author)  
VALUES ( '1', '1', 'test', 'kim' );

INSERT INTO comment (c_idx, b_idx, contents, author)  
VALUES ( '2', '1', 'a', 'lee' );
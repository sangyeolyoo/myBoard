<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
</head>
<body>
<div id="detailDiv">
	<form action="/editView" method="post">
		<input type="hidden" name="bno" value="${board.bno }" />
		<h2>게시글 조회</h2>

		<table class="board_view">
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>

			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="3">${board.title }</td>
					<th>조회수</th>
					<td>${board.readcnt }</td>
				</tr>
				<tr>
					<th>생성자</th>
					<td>${board.author }</td>
					<th>생성일</th>
					<td>${board.regdate }</td>
					<th>글번호</th>
					<td>${board.bno }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><a href="filedown/${files.bno }">${files.fileOriName }</a></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5" style="width: 100%;"><pre>${board.contents}</pre></td>
				</tr>
			</tbody>
		</table>
		<br /> 
		<input type="submit" value="수정하기" class="btn" id="edit" /> 
		<input type="button" value="목록으로" class="btn" onclick="javascript:location.href='/boardView'" />
	</form>
</div>
<%@ include file="comment.jsp" %>
	
</body>
</html>






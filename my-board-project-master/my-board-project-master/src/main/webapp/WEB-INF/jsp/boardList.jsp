<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
</head>
<body>
	<h2>게시판 목록</h2>
		<input type="hidden" name="bno" value="${row.bno }" />
		<table class="board_list">
			<colgroup>
				<col width="10%"/>
				<col width="*"/>
				<col width="15%"/>
				<col width="20%"/>
				<col width="5%"/>
				<col width="5%"/>
			</colgroup>
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(board) > 0}">
						<c:forEach items="${board }" var="row">
							<tr>
								<td>${row.bno }</td>
								<td class="title">
									<a href="/detail?bno=${row.bno }" name="title">${row.title }</a></td> 							
								<td>${row.author }</td>
								<td>${row.regdate }</td>
								<td>${row.readcnt }</td>
								<td><input type="checkbox" name="delCheck" value="${row.bno }" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<br /> 
		<a href="#this" class="btn" id="write">글쓰기</a>
		<a href="#this" class="btn" id="delete">삭제</a>
		<br /> 
		<br /> 
	
	<form action="/search" name="searchForm" method="get">	
		<div style="text-align:center">
			<select name="searchType">
				<option value="titleType" id="titleType">제목</option>
				<option value="idxType" id="idxType">글번호</option>
				<option value="authorType" id="authorType">작성자</option>		
			</select>
			<input type="text" name="keyword" />
			<input type="submit" value="검색" class="btn">
		</div>
			<input type="hidden" name="curPage" value="${pagination.curPage }"/>
			
	<div>
		<c:if test = "${pagination.curRange ne 1 }"> <!-- != -->
			<a href="#this" onClick="fn_paging(1)">[처음]</a>
		</c:if>
		<c:if test = "${pagination.curPage ne 1 }">
			<a href="#this" onClick="fn_paging('${pagination.prevPage}')">[이전]</a>
		</c:if>
		<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
			<c:choose>
				<c:when test = "${pageNum eq pagination.curPage }"> <!-- == -->
				
					<span style="font_weight: bold;"><a href="#this" onClick="fn_paging('${pageNum}')">${pageNum }</a></span>
				</c:when>
				<c:otherwise>
					<a href="#this" onClick="fn_paging('${pageNum}')">${pageNum }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0 }">
			<a href="#this" onClick="fn_paging('${pagination.nextPage}')">[다음]</a>
		</c:if>
		<c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0 }">
			<a href="#this" onClick="fn_paging('${pagination.pageCnt}')">[끝]</a>
		</c:if>
	</div>
	<div>
		총 게시글 수 : ${pagination.listCnt } / 총페이지수 : ${pagination.pageCnt }  / 현재 페이지 : ${pagination.curPage } / 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt }
	</div>

</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#write").on("click", function(e) {
				e.preventDefault();
				location.href="/regView";
			});
			
			$("#delete").on("click", function(e) {
				var checkArr = new Array();
				
				$("input[name='delCheck']:checked").each(function(){
					checkArr.push($(this).attr("value"));
				});
				
				$.ajax({
					url:"del",
					type: "POST",
					data: { delCheck : checkArr} ,
					error : function(){
						console.log('failed');
					},
					success : function(data) {
						console.log("success");
						location.href="/boardView";			
					}
				})
			});
		});
		
		function fn_paging(curPage){
			/* location.href="boardView?curPage="+curPage; */
			var link2 = document.location.href.split('curPage=');
			var link = document.location.href.split('?');
		
			if(link[0]=="http://localhost:8080/boardView")
				location.href=link[0]+"?curPage="+curPage;
			else 
				location.href=link2[0]+"curPage="+curPage;		
		};
	</script>
</body>
</html>


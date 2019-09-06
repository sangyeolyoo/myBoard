<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
</head>
<body>
	<div id="commentDiv">
		<form action="/comment/reg" name="commentForm">
			<h3>Comments  ${fn:length(comment) }</h3>
			<input type="hidden" name="b_idx" value="${board.bno }" />
			<input type="text" id="author" name="author" value="작성자"/>
			<input type="text" id="contents" name="contents" value="내용을 입력하세요.."/> 
			<a href="#this" id="add" class="btn" >등록</a>
			
			<c:choose>
				<c:when test="${fn:length(comment) > 0}">
					<c:forEach items="${comment }" var="c_row">
					<input type="hidden" name="c_idx" value="${c_row.c_idx }"/>

					<p align="justify">
						<span style="font-weight:bold">작성자 : ${c_row.author }</span> &nbsp; &nbsp;
						<a href="#this" id="edit${c_row.c_idx }" onClick="fn_inputForm('${c_row.c_idx}', '${c_row.contents }')" class="btn">수정</a>
						<a href="#this" id="delete${c_row.c_idx }" onClick="fn_deleting('${c_row.c_idx}', '${c_row.contents }')" class="btn">삭제</a>
					</p>

					<div class="commentContent${c_row.c_idx }">
						<span style="font-weight:bold">${c_row.contents }</span>
					</div>

					</c:forEach>
				</c:when>	
				<c:otherwise>
					<h5>조회된 결과가 없습니다.</h5><br>
				</c:otherwise>			
				</c:choose>
		</form>
	</div>
	<script>
		$(document).ready(function(){
			$("#add").on("click",function(e){
				var commentData = $("form[name=commentForm]").serialize();
				$.ajax({
					url:"comment/reg",
					type:"GET",
					data: commentData,
					error:function(){
						console.log('failed');
					},
					success:function(data){
						console.log('success');
						location.reload();
					}
				});
			});
			
			$("#author").on("mouseup", function(e){
				$(this).val("");
			});
			$("#contents").on("mouseup", function(e){
				$(this).val("");
			});
			
		});
		
		function fn_deleting(c_idx) {
			$.ajax ({
				url: '/comment/del?c_idx='+c_idx,
				type:'POST',
				success: function(data){
					location.reload();
				}	
			});
		};
		
		function fn_inputForm(c_idx, contents){
			for(var i=1; i<=${fn:length(comment)};i++){
				$("#delete"+i).hide();
				$("#edit"+i).hide();	
			}
			
			var a="";
			
			a+=' <input type="text" name="content'+c_idx+'" value="'+contents+'" />';
			a+=' <a href="#this" onclick="fn_editing('+c_idx+')" class="btn">댓글 수정</a>';
			
			$('.commentContent'+c_idx).html(a);
		};
		
		function fn_editing(c_idx) {
			var updateContent=$('[name=content'+c_idx+']').val();
			
			$.ajax({
				url:"comment/edit",
				type:"POST",
				data: {'contents' : updateContent, 'c_idx': c_idx},
				error:function(){
					console.log('failed');
				},
				success:function(data){
					console.log('success');
					location.reload();
				}
			});
		};
	</script>
</body>
</html>
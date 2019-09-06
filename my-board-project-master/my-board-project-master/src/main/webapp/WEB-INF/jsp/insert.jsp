<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
</head>
<body>
	<form action="/reg" method="post" enctype="multipart/form-data">
		<h2>게시글 작성</h2>
		<table class="board_view">
			<tbody>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" id="title" name="title" style="width:100%;" maxlength="50" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea id="contents" name="contents" ></textarea>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" id="author" name="author" style="width:100%;" maxlength="15" />
					</td>
				</tr>
				<tr>
					<input type = "file" name="files"></input>
				</tr>
			</tbody>
		</table>
		<br /> 
		<input type="submit" value="등록" class="btn" />
		<input type="button" value="목록" class="btn" onclick="javascript:location.href='/boardView'" />
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#contents').cleditor(); 
			
			$('#contents').keyup(function(e){
				var contents = $(this).val();
				/* var maxLength = $(this).attr("max"); */
				var maxLength=10;
				if(contents.length > maxLength){
					alert("경고! 글자수 제한");
					$(this).val($(this).val().substring(0,maxLength));
				}
			});
		});
	</script>
</body>
</html>
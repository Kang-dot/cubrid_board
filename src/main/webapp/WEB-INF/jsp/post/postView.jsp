<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="800">
		<tr>
			<th bgcolor="orange" width="60">글 번호</th>
			<th bgcolor="orange" width="60">작성일</th>
			<th bgcolor="orange" width="60">작성자</th>
			<th bgcolor="orange" width="60">내용</th>
		</tr>
		<tr>
			<th align="center">${Post.postNum}</th>
			<th align="center">${Post.postDateTime}</th>
			<th align="center">${Post.id}</th>
			<th align="center">${Post.content}</th>
		</tr>
	</table>
	<button type="button" onclick="location.href='${Post.postNum}/edit'">글 수정</button>
	<form action="/board/list/${Post.postNum}/delete" method="post" accept-charset="UTF-8">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="글 삭제">
	</form>

</body>

</html>
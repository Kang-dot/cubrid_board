<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="800">
		<tr>
			<th bgcolor="orange" width="60">글 번호</th>
			<th bgcolor="orange" width="60">작성일</th>
			<th bgcolor="orange" width="60">작성자</th>
			<th bgcolor="orange" width="60">제목</th>
			<th bgcolor="orange" width="60">조회수</th>
		</tr>
		<c:forEach var="Post" items="${PostList}">
			<tr>
				<th align="center">${Post.postNum}</th>
				<th align="center">${Post.postDateTime}</th>
				<th align="center">${Post.id}</th>
				<th align="center"><a href="list/${Post.postNum}">${Post.title}</a></th>
				<th align="center">${Post.counter}</th>
			</tr>
		</c:forEach>
	</table>
	<button type="button" onclick="location.href='regist'">글 쓰기</button>
</body>
</html>
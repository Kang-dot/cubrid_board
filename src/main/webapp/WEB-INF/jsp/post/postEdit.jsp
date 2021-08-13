<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
</head>
<body>
	<form action="/board/edit/${EditPost.postNum}" method="post" accept-charset="UTF-8">
		<input type="hidden" name="_method" value="PUT"/>
		<div>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" value="${EditPost.title}" readonly/>
		</div>
		<div>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" value="${EditPost.id}" readonly/>
		</div>
		<div>
			<label for="content">내용</label>
			<textarea rows="5" cols="30" id="content" name="content">${EditPost.content}</textarea>
		</div>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</form>
</body>
</html>
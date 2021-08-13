<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통계 날짜 조회</title>
</head>
<form action="/stats/list" method="post" accept-charset="UTF-8">
	<input type="date" name="date" id="date"/>
	<input type="submit" />
</form>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="800">
		<tr>
			<th bgcolor="orange" width="60">글 번호</th>
			<th bgcolor="orange" width="60">작성일</th>
			<th bgcolor="orange" width="60">제목</th>
			<th bgcolor="orange" width="60">조회수</th>
		</tr>
		<c:forEach var="Stats" items="${StatsList}">
			<tr>
				<th align="center">${Stats.postNum}</th>
				<th align="center">${Stats.statsDate}</th>
				<th align="center"><a href="list/${Stats.postNum}">${Stats.title}</a></th>
				<th align="center">${Stats.counter}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
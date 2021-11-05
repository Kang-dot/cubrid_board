<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GeneralCopyTest</title>
	</head>
	<body>
		<table border="1" cellpadding="0" cellspacing="0" width="800">
			<tr>
				<th bgcolor="orange" width="60">데이터개수</th>
				<th bgcolor="orange" width="60">실행시간</th>
				<th bgcolor="orange" width="60">결      과</th>
			</tr>
			<tr>
				<th align="center">${generalResult.getDataCounts()}개</th>
				<th align="center">${generalResult.getRunTime()}초</th>
				<th align="center">${generalResult.isResult()}</th>
			</tr>
		</table>
	</body>
</html>
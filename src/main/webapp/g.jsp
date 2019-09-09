<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>g.jsp</h3>
	
	${requestScope.x } <br />
	${sessionScope.x } <br />
	${applicationScope.x } <br />
	${stringList } <br />
	${date } <br />
	
</body>
</html>
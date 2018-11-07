<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/template.css" />
<link rel="stylesheet" type="text/css" href="css/${target}.css" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div class="container">
		<jsp:include page="${target}.jsp" />
	</div>
	<jsp:include page="bottom.jsp" />
</body>
</html>
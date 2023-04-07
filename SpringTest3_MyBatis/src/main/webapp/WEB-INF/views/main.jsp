<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="inc/top.jsp"/>
	<article>
		<h1>메인페이지</h1>
		<h3>
			<a href="${pageContext.request.contextPath }/write.bo"> 글쓰기 </a>
			<a href="${pageContext.request.contextPath }/list.bo"> 글목록 </a>
		</h3>
	</article>
</body>
</html>
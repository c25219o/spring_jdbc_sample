<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>タグサンプルの結果表示</title>
</head>
<body>
ふぁー<hr/>
	breakfast=<c:out value="${tagSampleModel.breakfast}"/><br/>
	lunch=<c:out value="${tagSampleModel.lunch}"/><br/>
	<hr/>
	<c:forEach var="d" items="${tagSampleModel.dinner}">
		<c:out value="${d}"/><br/>
	</c:forEach>
	<hr/>
	ラジオ体操第一<c:out value="${tagSampleModel.first}"/><br/>
	ラジオ体操第二<c:out value="${tagSampleModel.second}"/><br/>
	<hr/>
	干支は、<c:out value="${tagSampleModel.eto}"/>ですね！(ドヤ顔<br/>
	<hr/>
	<c:out value="${tagSampleModel.fukawa}"/>を選びましたね！<br/>
	<br/>
	<a href="returnMenu.html">メニューに戻る</a>
</body>
</html>
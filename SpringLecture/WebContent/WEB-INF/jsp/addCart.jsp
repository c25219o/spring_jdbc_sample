<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>過ー渡</title>
</head>
<body>
何の変哲もないカート(SpringWebMVC利用版)
<a href="returnMenu.html">メニューに戻る</a>
<hr/>
${ errorMsg }
${ fullfull }
<form action="add.html" method="POST">
	商品名：<input type="text" name="name" size="10" value=""/><form:errors path="cartParam.name" /><br/>
	個数う：<input type="text" name="value" size="10" value=""/><form:errors path="cartParam.value" /><br/>

	<input type="submit" value="カートに追加ッ"/>
</form>

	<table border="1">
		<tr><th>商品名</th><th>個数</th></tr>
		<c:forEach var="cg" items="${cart.allCartGoods}">
		<tr>
			<td><c:out value="${cg.name}"/></td>
			<td><c:out value="${cg.value}"/></td>
		</tr>
		</c:forEach>
	</table>
	<a href="clear.html">カートを空にする</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員検索結果</title>
</head>
<body>
検索結果<br/><br/>
<a href="searchMember.html">会員番号入力に戻る</a><br/>
<a href="menu.html">メニューに戻る</a><br/>
<hr/>
<!-- c:if test="$fn:length(${memberList})> 0" -->
	<table border="1">
		<tr><th>会員番号</th><th>氏名</th></tr>
		<c:forEach var="member" items="${memberList}">
			<tr><td><c:out value="${member.memNum}"/></td>
			    <td><c:out value="${member.lstName}"/><c:out value="${member.fstName}"/></td>
			</tr>
		</c:forEach>
	</table>
<!-- /c:if -->

</body>
</html>
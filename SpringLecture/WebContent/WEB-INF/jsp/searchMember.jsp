<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員検索</title>
</head>
<body>
会員検索<hr/>
<form action="executeMemberSearch.html" method="POST">
会員番号:<input type="text" name="memberNumber"/><form:errors path="searchMember.memberNumber" />
<br/><br/>
<input type="submit" value="会員検索実行"/>
</form>
</body>
</html>
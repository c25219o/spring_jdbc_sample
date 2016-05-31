<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品登録確認</title>
</head>
<body>
確認画面<hr/>
番号：<c:out value="${insertGoods.goodsNum}"/><br/>
商品名：<c:out value="${insertGoods.name}"/><br/>
価格：<c:out value="${insertGoods.price}"/><br/>
説明：<c:out value="${insertGoods.exp}"/><br/>
メーカー：<c:out value="${insertGoods.maker}"/><br/>
<form action="commitInsertGoods.html" method="POST">
  <input type="submit" value="登録"/>
</form>
<form action="insertGoods.html" method="POST">
  <input type="submit" value="もどる"/>
</form>
</body>
</html>
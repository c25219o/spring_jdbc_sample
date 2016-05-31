<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品登録</title>
</head>
<body>
商品登録テスト<br/>
<a href="menu.html">メニューに戻る</a><br/>
<hr/>
<form action="executeInsertGoods.html" method="POST">
番号：<input type="text" name="goodsNum" value="${insertGoods.goodsNum}"/><br/>
商品名：<input type="text" name="name" value="${insertGoods.name}"/><br/>
価格：<input type="text" name="price"  value="${insertGoods.price}"/><br/>
説明：<input type="text" name="exp"   value="${insertGoods.exp}"/><br/>
メーカー：<input type="text" name="maker" value="${insertGoods.maker}"/><br/>
<br/>
<input type="submit" value="商品登録">
</form>
</body>
</html>
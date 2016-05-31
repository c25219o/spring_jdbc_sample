<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Springタグ</title>
</head>
<body>
いろんなタグを使う<br/>
<a href="returnMenu.html">メニューに戻る</a>
<hr/>

<form action="executeTagSample.html" method="POST">
	<ul><li>単発のチェックボックス</ul><br/>
	<input type="checkbox" name="breakfast" checked="${tagSampleModel.breakfast}"/>今朝、朝食を食べた人<br/>
	<input type="checkbox" name="lunch" checked="${tagSampleModel.lunch}"/>昼食を食べたい人<br/>
	<hr/>
	<ul><li>複数でセットのチェックボックス</ul><br/>
	夕食に食べたいものは？<br/>
	<input type="checkbox" name="dinner" value="fish"/>おさかな<br/>
	<input type="checkbox" name="dinner" value="chicken"/>鳥さん<br/>
	<input type="checkbox" name="dinner" value="beef"/>もうもうさん<br/>
	<hr/>
	<ul><li>単発のラジオボタン</ul><br/>
	やったことある？<br/>
	<input type="radio" name="first"/>ラジオ体操第一<br/>
	<input type="radio" name="second"/>ラジオ体操第二<br/>
	<hr/>
	<ul><li>グループのラジオボタン</ul><br/>
	あなたの干支は？<br/>
	<input type="radio" name="eto" value="子"/>ねずみ<br/>
	<input type="radio" name="eto" value="丑"/>うし<br/>
	<input type="radio" name="eto" value="子、丑以外"/>それ以外<br/>
	<hr/>
	<ul><li>セレクト</ul><br/>
	一つ選びな？
	<select name="fukawa">
		<option value="充電">ひとんちで充電すんなよ。</option>
		<option value="かまぼこ板">おまえんちの表札、かまぼこの板じゃない？</option>
		<option value="階段">おまえんち階段、急だな。</option>
		<option value="一輪車">お前んち、何台一輪車あるんだよ！</option>
	</select>

	<br/>
	<br/>
	<input type="submit" value="送信するッ"/>
</form>

</body>
</html>
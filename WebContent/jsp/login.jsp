<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- タグライブラリの使用を宣言する（必要に応じて） -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- cssの埋め込み -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css?date=20200626">


<title>ログイン画面</title>
</head>

<body>
	<h1>ログイン画面</h1>

	<p>名前と合言葉を入力してください</p>

	<!-- エラーメッセージ -->
	<div class="box">
		<p id="error">${loginBean.emsg}</p>
	</div>

	<!-- POSTメソッドでテキストを送信 -->
	<form action="/ShoppingSite/loginservlet" method="post">
		<p>
			名前：<input type="text" name="username">
		</p>
		<p>
			合言葉：<input type="text" name="password">
		</p>
		<input type="submit" value="送信">
	</form>

</body>

</html>
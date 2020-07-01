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


<title>登録確認画面</title>
</head>

<body>
	<h1>登録確認画面</h1>

	本当に登録しますか？

	<!-- POSTメソッドでテキストを送信 -->
	<form action="/ShoppingSite/administratorservlet" method="post">
		<p>
			ID<input class="id" type="hidden" name="id"
				value="${administratorBean.id}">
		</p>
		<p>
			名前<input class="name" type="hidden" name="name"
				value="${administratorBean.name}">
		</p>
		<p>
			価格<input class="price" type="hidden" name="price"
				value="${administratorBean.price}">
		</p>
		<p>
			強さ<input class="power" type="hidden" name="power"
				value="${administratorBean.power}">
		</p>
		<p>
			分類<input class="category" type="hidden" name="category"
				value="${administratorBean.category}">
		</p>
		<p>
			説明<input class="explanation" type="hidden" name="explanation"
				value="${administratorBean.explanation}">
		</p>


		<button class="button" type="submit" name="Action" value="Register">登録する</button>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_register.jsp'">しない</button>
		<!--  name="Action" value="GotoMenu" -->
	</form>

</body>

</html>
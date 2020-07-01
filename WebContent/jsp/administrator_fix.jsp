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


<title>家来変更画面</title>
</head>

<body>
	<h1>家来変更画面</h1>



	<p id="error">${administratorBean.error}</p>
	<p id="success">${administratorBean.success}</p>
	<p id="failure">${administratorBean.failure}</p>

	<!-- POSTメソッドでテキストを送信 -->
	<form action="/ShoppingSite/administratorservlet" method="post">
		<p>
			ID<input class="id" type="text" name="id"
				value="${administratorBean.id}">
			<button class="button" type="submit" name="Action" value="FixDisplay">表示</button>
		</p>
		<p>
			名前<input class="name" type="text" name="name" value="${adBean.name}">
		</p>
		<p>
			価格<input class="price" type="text" name="price"
				value="${adBean.price}">
		</p>
		<p>
			強さ<input class="power" type="text" name="power"
				value="${adBean.power}">
		</p>
		<p>
			分類<input class="category" type="text" name="category"
				value="${adBean.category}">
		</p>
		<p>
			説明<input class="explanation" type="text" name="explanation"
				value="${adBean.explanation}">
		</p>


		<button class="button" type="submit" name="Action" value="Fix">変更</button>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_menu.jsp'">戻る</button>
	</form>



</body>

</html>
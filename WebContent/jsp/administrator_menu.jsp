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


<title>管理者メニュー画面</title>
</head>

<body>
	<h1>管理者メニュー画面</h1>

	<ul>

		<li>
			<form action="/ShoppingSite/administratorservlet" method="post">
				<button class="button" type="submit" name="Action" value="List">家来一覧
				</button>
			</form>
		</li>

		<li>
			<button class="button" type="button"
				onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_register.jsp'">
				家来情報新規登録</button>
		</li>


		<li>
			<button class="button" type="button"
				onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_fix.jsp'">
				家来情報変更</button>
		</li>

		<li>
			<button class="button" type="button"
				onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_delete.jsp'">
				家来情報削除</button>
		<li>
		<li>
			<button class="button" type="button"
				onclick="location.href='http://localhost:8080/ShoppingSite/jsp/login.jsp'">
				ログアウト</button>
		<li>
	</ul>



</body>

</html>
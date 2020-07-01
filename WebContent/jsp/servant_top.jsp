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
	href="${pageContext.request.contextPath}/css/login.css?date=20200629">

<title>家来トップ</title>
</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<main>

		<h1>家来トップ</h1>


		<ul>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="List">家来一覧</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Search">家来検索</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantcandidateservlet" method="post">
					<button class="button" type="submit" name="Action"
						value="Candidate">家来候補</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Logout">ログアウト</button>
				</form>
			<li>
		</ul>


	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>

</html>
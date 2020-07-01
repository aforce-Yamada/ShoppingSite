<!-- 家来がいませんjsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- タグライブラリの使用を宣言する（必要に応じて） -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- cssの埋め込み -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css?date=20200626">


<title>エラー画面</title>

</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<main>

		<h1>エラー画面</h1>

		<p>家来候補がいませんでした</p>

		<p>
			<img src="http://localhost:8080/ShoppingSite/image/onigashima.png"
				style="width: 250px; height: 250px;">
		</p>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/servant_top.jsp'">TOP</button>
	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
<!-- 購入完了jsp -->

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

<title>契約完了画面</title>

</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<main>

		<h1>契約完了画面</h1>

		<p>ご契約ありがとうございます。</p>

		<table>

			<c:forEach items="${list}" var="servantBean">

				<tr>

					<form action="/ShoppingSite/servantresultservlet" method="post">

						<td><input type="hidden" name="image"
							value="${servantBean.image}"> <img
							src="${servantBean.image}"></td>
						<td><input type="hidden" name="name"
							value="${servantBean.name}">${servantBean.name}</td>
						<td><input type="hidden" name="quantity"
							value="${servantBean.quantity}">${servantBean.quantity}体</td>


					</form>

				</tr>

			</c:forEach>

		</table>

		<p>が家来になりました。</p>

		<p>鬼退治頑張ってください。</p>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/servant_top.jsp'">TOP</button>
	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
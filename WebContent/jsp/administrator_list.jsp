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


<title>家来一覧 (管理者ページ)</title>
</head>

<body>
	<h1>家来一覧 (管理者ページ)</h1>

	<p>今いる家来たちです</p>

	<table>
		<tr>
			<th>ID</th>
			<th>name</th>
			<th>price</th>
			<th>power</th>
			<th>category</th>
			<th>explanation</th>
		</tr>

		<c:forEach items="${servantBean}" var="servantBean">

			<tr>
				<td><input type="hidden" name="id" value="${servantBean.id}">${servantBean.id}</td>
				<td><input type="hidden" name="name"
					value="${servantBean.name}">${servantBean.name}</td>
				<td><input type="hidden" name="price"
					value="${servantBean.price}">きびだんご ${servantBean.price}個</td>
				<td><input type="hidden" name="power"
					value="${servantBean.power}">${servantBean.power}</td>
				<td><input type="hidden" name="category"
					value="${servantBean.category}">${servantBean.category}</td>
				<td><input type="hidden" name="explanation"
					value="${servantBean.explanation}">${servantBean.explanation}</td>
			</tr>

		</c:forEach>
	</table>


	<button class="button" type="button"
		onclick="location.href='http://localhost:8080/ShoppingSite/jsp/administrator_menu.jsp'">戻る</button>


</body>

</html>

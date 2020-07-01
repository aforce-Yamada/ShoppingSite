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


<title>家来検索結果</title>
</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<main>
		<h1>家来検索結果</h1>


		<form action="/ShoppingSite/servantservlet" method="get">
			<input type="search" name="search" placeholder="名前を入力">
			<button class="button" type="submit" name="Action" value="Search">検索</button>
		</form>

		<ul class="button">
			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Land">陸上</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Marine">海洋</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Special">特殊</button>
				</form>
			</li>

			<li>
				<form action="/ShoppingSite/servantservlet" method="get">
					<button class="button" type="submit" name="Action" value="Legend">伝説</button>
				</form>
			</li>
		</ul>

		<table>
			<tr>
				<th></th>
				<th>名前</th>
				<th>価格</th>
				<th>強さ</th>
				<th>説明</th>
				<th>数</th>
			</tr>

			<c:forEach items="${servantBean}" var="servantBean">


				<tr>
					<form action="/ShoppingSite/servantcandidateservlet" method="post">
						<input type="hidden" name="id" value="${servantBean.id}">
						<td><input type="hidden" name="image"
							value="${servantBean.image}"> <img
							src="${servantBean.image}"></td>
						<td><input type="hidden" name="name"
							value="${servantBean.name}">${servantBean.name}</td>
						<td><input type="hidden" name="price"
							value="${servantBean.price}">きびだんご ${servantBean.price}個</td>
						<td><input type="hidden" name="power"
							value="${servantBean.power}">${servantBean.power}</td>
						<td><input type="hidden" name="explanation"
							value="${servantBean.explanation}">${servantBean.explanation}</td>

						<td><select class="quantity" name="quantity">
								<option value=""></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select></td>


						<td class="button">
							<button class="button" type="submit" name="Action"
								value="Candidate">家来候補にする</button>
						</td>
					</form>
				</tr>

			</c:forEach>
		</table>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/servant_top.jsp'">TOP</button>

	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>

</html>
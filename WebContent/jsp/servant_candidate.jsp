<!-- カートjsp -->

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


<title>家来候補</title>
</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<main>
		<h1>家来候補</h1>


		<table>
			<tr>
				<th></th>
				<th>名前</th>
				<th>価格</th>
				<th>数</th>
				<th>小計</th>
				<th>税</th>
			</tr>

			<c:forEach items="${list}" var="servantBean">

				<tr>

					<form action="/ShoppingSite/servantcandidateservlet" method="post">

						<input type="hidden" name="id" value="${servantBean.id}">
						<td><input type="hidden" name="image"
							value="${servantBean.image}"> <img
							src="${servantBean.image}"></td>

						<td><input type="hidden" name="name"
							value="${servantBean.name}">${servantBean.name}</td>


						<td><input type="hidden" name="price"
							value="${servantBean.price}">きびだんご ${servantBean.price}個
						</td>

						<td><select class="item" name="quantity">
								<option value="${servantBean.quantity}">${servantBean.quantity}</option>
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

						<td>きびだんご <span class="subtotal">${servantBean.price * servantBean.quantity}</span>個
						</td>

						<td>+<span class="subtotal">${servantBean.price * servantBean.quantity}</span>個
						</td>

						<td class="button">
							<button class="button" type="submit" name="Action" value="Change">変更する</button>
						</td>

						<td class="button">
							<button class="button" type="submit" name="Action" value="Delete">お別れする</button>
						</td>

					</form>
				</tr>

			</c:forEach>

		</table>

		<div id="total">合計(税込）：きびだんご</div>

		<form action="/ShoppingSite/servantcandidateservlet" method="post">
			<button class="button" type="submit" name="Action" value="Friends">家来にする</button>
		</form>

		<form action="/ShoppingSite/servantservlet" method="get">
			<button class="button" type="submit" name="Action" value="List">家来一覧へ戻る</button>
		</form>

		<button class="button" type="button"
			onclick="location.href='http://localhost:8080/ShoppingSite/jsp/servant_top.jsp'">TOP</button>

	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>

<script>
	// subtotal というクラスの要素を全て取得し、配列で保持
	let targetElem = document.querySelectorAll('.subtotal');
	let total = 0;

	for (let i = 0; i < targetElem.length; i++) {
		// 取得した要素から内容を取り出し、total に足していく
		// textContent は文字列を返すので、数値にキャストする
		total += Number(targetElem[i].textContent)
	};
	// p要素を作成
	let element = document.createElement('span')
	// 要素の内容に total を追加
	element.innerText = total + "個"
	// id が total の要素の最後に p 要素を追加
	let div = document.getElementById('total')
	div.appendChild(element)
</script>

</html>
// 購入画面サーブレット

package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ServantBean;

//親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ServantResultServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("post");

		// 文字のエンコードをUTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// ユーザによって入力された情報を取り出す
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String power = request.getParameter("power");
		String category = request.getParameter("category");
		String explanation = request.getParameter("explanation");
		String image = request.getParameter("image");

		// 購入数
		String quantity = request.getParameter("quantity");

		// 取り出した情報を ServantBean に格納する
		ServantBean servantBean = new ServantBean();
		servantBean.setId(id);
		servantBean.setName(name);
		servantBean.setPrice(price);
		servantBean.setPower(power);
		servantBean.setCategory(category);
		servantBean.setExplanation(explanation);
		servantBean.setId(image);

		servantBean.setQuantity(quantity);

		// JSPから取得
		String action = request.getParameter("Action");

		switch (action) {

		case "Makefriends":

			HttpSession session = request.getSession(false);

			ArrayList<ServantBean> list = (ArrayList<ServantBean>) session.getAttribute("list");

			// 画面遷移
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/servant_complete.jsp");
			rDispatcher.forward(request, response);

			// セッション管理
			session = request.getSession(false);

			session.removeAttribute("list");
			System.out.println("契約が成立したためカートが空になりました。");

			break;

		default:
			break;
		}

	}
}

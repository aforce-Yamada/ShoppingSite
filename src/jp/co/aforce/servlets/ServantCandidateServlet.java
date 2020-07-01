// カートサーブレット
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

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ServantCandidateServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

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
		String purchasedNum;

		// 取り出した情報を ServantBean に格納する
		ServantBean servantBean = new ServantBean();
		servantBean.setId(id);
		servantBean.setName(name);
		servantBean.setPrice(price);
		servantBean.setPower(power);
		servantBean.setCategory(category);
		servantBean.setExplanation(explanation);
		servantBean.setImage(image);

		servantBean.setQuantity(quantity);

		// JSPから取得
		String action = request.getParameter("Action");

		ArrayList<ServantBean> newList = new ArrayList<ServantBean>();

		switch (action) {

		case "Candidate":

			if (quantity != "" && quantity != null) {

				// ドロップダウンリストから購入数を取得
				purchasedNum = request.getParameter(price + "list");
				request.setAttribute("purchasedNum", purchasedNum);

				// セッション管理
				HttpSession session = request.getSession(false);

				ArrayList<ServantBean> list = (ArrayList<ServantBean>) session.getAttribute("list");

				if (list == null) {
					list = new ArrayList<ServantBean>();
					session = request.getSession(true);
				}
				list.add(servantBean);
				//session.setAttribute("servantBean", list.add(servantBean));
				session.setAttribute("list", list);

				// 画面遷移
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/servant_candidate.jsp");
				rDispatcher.forward(request, response);

			} else {
				// 画面遷移
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/servant_candidate.jsp");
				rDispatcher.forward(request, response);
			}
			break;

		case "Delete":

			// セッション管理
			HttpSession session = request.getSession(false);

			ArrayList<ServantBean> list = (ArrayList<ServantBean>) session.getAttribute("list");
			//ArrayList<ServantBean> newList = new ArrayList<ServantBean>();

			//newList = new ArrayList<ServantBean>();

			for (ServantBean servant : list) { //
				String getId = servant.getId(); //

				if (!(getId.equals(id))) {
					newList.add(servant);

				}
			}
			session.setAttribute("list", newList);

			// 画面遷移
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/servant_candidate.jsp");
			rDispatcher.forward(request, response);

			break;

		case "Change":

			// セッション管理
			session = request.getSession(false);

			list = (ArrayList<ServantBean>) session.getAttribute("list");

			for (ServantBean servant : list) {

				String getId = servant.getId();
				if (getId.equals(id)) {
					servant.setQuantity(quantity);
				}
				newList.add(servant);
			}
			session.setAttribute("list", newList);

			// 画面遷移
			rDispatcher = request.getRequestDispatcher("/jsp/servant_candidate.jsp");
			rDispatcher.forward(request, response);

			break;

		case "Friends":

			session = request.getSession(false);

			list = (ArrayList<ServantBean>) session.getAttribute("list");

			if (list == null) {
				// 画面遷移
				rDispatcher = request.getRequestDispatcher("/jsp/servant_none.jsp");
				rDispatcher.forward(request, response);
			}

			// 画面遷移
			rDispatcher = request.getRequestDispatcher("/jsp/servant_result.jsp");
			rDispatcher.forward(request, response);

			break;

		default:
			break;
		}

	}
}

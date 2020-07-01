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
import jp.co.aforce.models.ServantModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class ServantServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードをUTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		/* 画面遷移 */
		// JSPから取得
		String action = request.getParameter("Action");

		// 遷移先 TOP画面に飛ばす TODO(機能していない)
		String forward_jsp = "/jsp/servant_top.jsp";

		switch (action) {

		/* 一覧表示 */
		case "List":
			forward_jsp = "/jsp/servant_list.jsp";

			// データベースに入力
			ServantModel servantModel = new ServantModel();

			// 家来情報を全て表示
			ArrayList<ServantBean> listServantBean = servantModel.selectAll();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 検索 */
		case "Search":
			//forward_jsp = "/jsp/servant_search.jsp";

			// ユーザによって入力された情報を取り出す
			String search = request.getParameter("search");

			// 取り出した情報を loginBean に格納する
			ServantBean servantBean = new ServantBean();
			servantBean.setSearch(search);

			// ②入力チェック
			if (search != "" && search != null) {

				forward_jsp = "/jsp/servant_search.jsp";

				// 家来情報を全て表示
				servantModel = new ServantModel();
				listServantBean = servantModel.search(search);
				request.setAttribute("servantBean", listServantBean);

			} else {
				forward_jsp = "/jsp/servant_search.jsp";
				// 未入力あり→エラーメッセージ
				//servantBean.setEmsg("キーワードを入力してください");
				//request.setAttribute("servantBean", servantBean);

			}

			break;

		/* 陸上 */
		case "Land":
			forward_jsp = "/jsp/servant_search.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.land();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 海洋 */
		case "Marine":
			forward_jsp = "/jsp/servant_search.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.marine();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 特殊 */
		case "Special":
			forward_jsp = "/jsp/servant_search.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.special();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 伝説 */
		case "Legend":
			forward_jsp = "/jsp/servant_search.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.legend();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* ログアウト */
		case "Logout":
			forward_jsp = "/jsp/login.jsp";

			// セッション管理
			HttpSession session = request.getSession(false);

			session.invalidate();
			session = request.getSession(false);

			break;

		/* 価格の安い順 */
		case "SortPriceA":
			forward_jsp = "/jsp/servant_list.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.sortPriceA();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 価格の高い順 */
		case "SortPriceD":
			forward_jsp = "/jsp/servant_list.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.sortPriceD();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 強い順 */
		case "SortPowerA":
			forward_jsp = "/jsp/servant_list.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.sortPowerA();
			request.setAttribute("servantBean", listServantBean);

			break;

		/* 弱い順 */
		case "SortPowerD":
			forward_jsp = "/jsp/servant_list.jsp";

			// 家来情報を表示
			servantModel = new ServantModel();
			listServantBean = servantModel.sortPowerD();
			request.setAttribute("servantBean", listServantBean);

			break;

		default:
			forward_jsp = null;
			break;
		}

		// 画面遷移 (forward_jspに認定されているJSPへディスパッチ)
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}
}

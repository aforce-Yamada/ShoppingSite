package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/login.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードをUTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// ユーザによって入力された情報を取り出す
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 取り出した情報を loginBean に格納する
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		// モデルをインスタンス化する
		LoginModel loginModel = new LoginModel();
		String forward_jsp = "/jsp/login.jsp";

		// セッション管理
		HttpSession session = request.getSession(false);

		// 入力された情報がDBに存在するか調べる
		/* 一般ユーザー */
		if (loginModel.userCheck(username, password)) {

			if (session == null) {

				/* 認証済みにセット */
				session = request.getSession(true);
				session.setAttribute("login", username);
				String sessionId = session.getId();
				System.out.println(sessionId);
			}

			System.out.println("名前：" + username + "合言葉：" + password);
			// ログインに成功した先のJSPを指定
			forward_jsp = "/jsp/servant_top.jsp";

			/* 管理者 */
		} else if (loginModel.administratorCheck(username, password)) {

			/* 認証済みにセット */
			session.setAttribute("login", "OK");

			System.out.println("管理者名：" + username + "合言葉：" + password);
			forward_jsp = "/jsp/administrator_menu.jsp";

			// ログインが失敗したときの処理
		} else {

			/* 認証に失敗 */
			session.setAttribute("status", "Not Auth");

			// エラーメッセージを認定
			loginBean.setEmsg("名前または合言葉が違います");
			request.setAttribute("loginBean", loginBean);
		}
		// forward_jspに認定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}
}

package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.AdministratorBean;
import jp.co.aforce.beans.AdministratorDisplayBean;
import jp.co.aforce.beans.ServantBean;
import jp.co.aforce.models.AdministratorModel;
import jp.co.aforce.models.ServantModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class AdministratorServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// GETリクエストはあり得ないので、無条件でメニュー画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/administrator_menu.jsp");
		rDispatcher.forward(request, response);
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

		// 取り出した情報を AdministratorBean に格納する
		AdministratorBean administratorBean = new AdministratorBean();
		administratorBean.setId(id);
		administratorBean.setName(name);
		administratorBean.setPrice(price);
		administratorBean.setPower(power);
		administratorBean.setCategory(category);
		administratorBean.setExplanation(explanation);

		/* 画面遷移 */
		// JSPから取得
		String action = request.getParameter("Action");

		// 遷移先
		String forward_jsp = null;

		switch (action) {

		/* 一覧表示 */
		case "List":
			forward_jsp = "/jsp/administrator_list.jsp";

			// データベースに入力
			ServantModel servantModel = new ServantModel();

			// 家来情報を全て表示
			ArrayList<ServantBean> listServantBean = servantModel.selectAll();
			request.setAttribute("servantBean", listServantBean);

			break;

		case "Register":

			// ②入力チェック
			if (id != "" && id != null && name != "" && name != null && price != "" && id != null
					&& power != "" && power != null && category != "" && category != null
					&& explanation != "" && explanation != null) {
				forward_jsp = "/jsp/administrator_register.jsp";
				// ③データベースに入力
				AdministratorModel administratorModel = new AdministratorModel();

				if (administratorModel.register(id, name, price, power, category, explanation) == true) {
					administratorBean.setSuccess("登録に成功しました");
					request.setAttribute("administratorBean", administratorBean);

					// 入力情報クリア
					administratorBean.setId(null);
					administratorBean.setName(null);
					administratorBean.setPrice(null);
					administratorBean.setPower(null);
					administratorBean.setCategory(null);
					administratorBean.setExplanation(null);
					request.setAttribute("administratorBean", administratorBean);

				} else {
					administratorBean.setFailure("登録に失敗しました");
					request.setAttribute("administratorBean", administratorBean);
				}
			} else {
				// 未入力あり→エラーメッセージ
				administratorBean.setError("入力されていない項目があります");
				request.setAttribute("administratorBean", administratorBean);

				forward_jsp = "/jsp/administrator_register.jsp";
			}
			break;

		case "FixDisplay":
			forward_jsp = "/jsp/administrator_fix.jsp";

			// ②入力チェック
			if (id != "" && id != null) {

				// ③データベースに入力
				AdministratorModel administratorModel = new AdministratorModel();

				if (administratorModel.display(id) != null) {

					// ID表示
					request.setAttribute("administratorBean", administratorBean);
					// 家来情報を全て表示
					AdministratorDisplayBean adBean = administratorModel.display(id);
					request.setAttribute("adBean", adBean);

				} else {
					administratorBean.setFailure("入力されたIDの家来は存在しません");

					// 入力情報の保持
					administratorBean.setId(id);
					request.setAttribute("administratorBean", administratorBean);
				}

			} else {
				// 未入力あり→エラーメッセージ
				administratorBean.setError("IDが入力されていません");
				request.setAttribute("administratorBean", administratorBean);
			}
			break;

		case "Fix":
			forward_jsp = "/jsp/administrator_fix.jsp";
			// ②入力チェック
			if (id != "" && id != null && name != "" && name != null && price != "" && price != null
					&& power != "" && power != null && category != "" && category != null
					&& explanation != "" && explanation != null) {

				// ③データベースに入力
				AdministratorModel administratorModel = new AdministratorModel();

				if (administratorModel.fix(id, name, price, power, category, explanation) == true) {
					administratorBean.setSuccess("変更に成功しました");

					// 入力情報(ID)クリア
					administratorBean.setId(null);
					request.setAttribute("administratorBean", administratorBean);

				} else {
					administratorBean.setFailure("変更に失敗しました");
					request.setAttribute("administratorBean", administratorBean);

					AdministratorDisplayBean adBean = new AdministratorDisplayBean();
					adBean.setId(id);
					adBean.setName(name);
					adBean.setPrice(price);
					adBean.setPower(power);
					adBean.setCategory(category);
					adBean.setExplanation(explanation);
					request.setAttribute("adBean", adBean);
				}

			} else {
				// 未入力あり→エラーメッセージ
				administratorBean.setError("入力されていない項目があります");
				request.setAttribute("administratorBean", administratorBean);
			}
			break;

		case "DeleteDisplay":
			forward_jsp = "/jsp/administrator_delete.jsp";

			// ②入力チェック
			if (id != "" && id != null) {

				// ③データベースに入力
				AdministratorModel administratorModel = new AdministratorModel();

				if (administratorModel.display(id) != null) {

					// ID表示
					request.setAttribute("administratorBean", administratorBean);
					// 家来情報を全て表示
					AdministratorDisplayBean adBean = administratorModel.display(id);
					request.setAttribute("adBean", adBean);

				} else {
					administratorBean.setFailure("入力されたIDの家来は存在しません");
					request.setAttribute("administratorBean", administratorBean);
				}

			} else {
				// 未入力あり→エラーメッセージ
				administratorBean.setError("IDが入力されていません");
				request.setAttribute("administratorBean", administratorBean);
			}
			break;

		case "Delete":
			forward_jsp = "/jsp/administrator_delete.jsp";
			// ②入力チェック
			if (id != "" && id != null) {

				// ③データベースに入力
				AdministratorModel administratorModel = new AdministratorModel();

				if (administratorModel.delete(id) == true) {
					administratorBean.setSuccess("削除に成功しました");

					// 入力情報(ID)クリア
					administratorBean.setId(null);
					request.setAttribute("administratorBean", administratorBean);

				} else {
					administratorBean.setFailure("削除に失敗しました");
					request.setAttribute("administratorBean", administratorBean);
				}

			} else {
				// 未入力あり→エラーメッセージ
				administratorBean.setError("IDが入力されていません");
				request.setAttribute("administratorBean", administratorBean);
			}
			break;

		default:
			forward_jsp = null;
			break;
		}

		// 画面遷移 (forward_jspに認定されているJSPへディスパッチ)
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}
}

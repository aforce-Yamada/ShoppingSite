// Model アプリケーションの主たる処理やデータの格納などを行う
package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class LoginModel {

	/**
	 * 入力されたデータがDBに上に存在するかどうかを調べる。
	 *
	 * @param username ユーザ名
	 * @param password パスワード
	 * @return ログイン成功=true, 失敗=false
	 */
	// ログインチェック(一般ユーザー)
	public boolean userCheck(String username, String password) {
		// 実行結果を格納する変数
		ResultSet rs = null;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users` WHERE `name`='" + username + "' AND `password`='" + password + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("userCheckで例外が発生しました");
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	// ログインチェック(管理者)
	public boolean administratorCheck(String username, String password) {
		// 実行結果を格納する変数
		ResultSet rs = null;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `administrators` WHERE `name`='" + username + "' AND `password`='" + password
					+ "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("administratorCheckで例外が発生しました");
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}
}

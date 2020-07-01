// Model アプリケーションの主たる処理やデータの格納などを行う
// データベース一覧表示・登録・変更・削除
package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.beans.AdministratorDisplayBean;
import jp.co.aforce.util.DBUtil;

public class AdministratorModel {

	// データベース登録
	public boolean register(String id, String name, String price,
			String power, String category, String explanation) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL

			String SQL = "INSERT INTO servants (servant_id, name, price, power, category_id, explanation) "
					+ "VALUES ('" + id + "','" + name + "'," + price + ",'" + power + "','"
					+ category + "','" + explanation + "')";

			rs = DBUtil.execute(SQL);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("registerで例外が発生しました");

		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	// データベース取得
	public AdministratorDisplayBean display(String id) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT servant_id, name, price, power, category_id, explanation FROM servants WHERE servant_id = '"
					+ id + "'";

			rs = DBUtil.execute(SQL);
			id = rs.getString("servant_id");
			String name = rs.getString("name");
			String price = rs.getString("price");
			String power = rs.getString("power");
			String category = rs.getString("category_id");
			String explanation = rs.getString("explanation");
			System.out.println("ID:" + id + "名前:" + name + "価格:" + price + "強さ:" + power
					+ "分類:" + category + "説明:" + explanation);

			// 取り出した情報を AdministratorBean に格納する
			AdministratorDisplayBean adBean = new AdministratorDisplayBean();
			adBean.setId(id);
			adBean.setName(name);
			adBean.setPrice(price);
			adBean.setPower(power);
			adBean.setCategory(category);
			adBean.setExplanation(explanation);

			return adBean;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("displayで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	// データベース変更
	public boolean fix(String id, String name, String price,
			String power, String category, String explanation) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "UPDATE servants SET servant_id = '" + id + "' , name = '" + name + "', price = '" + price
					+ "',"
					+ " power = '" + power + "', category_id = '" + category + "', explanation = '" + explanation + "'"
					+ "WHERE servant_id = '" + id + "'";

			rs = DBUtil.execute(SQL);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fixで例外が発生しました");

		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	// データベース削除
	public boolean delete(String id) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "DELETE FROM servants WHERE servant_id = '" + id + "'";

			rs = DBUtil.execute(SQL);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteで例外が発生しました");

		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

}

//Model アプリケーションの主たる処理やデータの格納などを行う
// データベース一覧表示
package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.beans.ServantBean;
import jp.co.aforce.util.DBUtil;

public class ServantModel {

	/* 一覧 */
	public ArrayList<ServantBean> selectAll() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM servants";
			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			// データベースの一番上
			rs.beforeFirst();

			while (rs.next()) {

				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectAllで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}
	}

	/* 検索 */
	public ArrayList<ServantBean> search(String search) {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants WHERE name LIKE '%" + search + "%'";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));
				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 陸上 */
	public ArrayList<ServantBean> land() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants WHERE category_id = 'C001'";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("landで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 海洋 */
	public ArrayList<ServantBean> marine() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants WHERE category_id = 'C002'";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("marineで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 特殊 */
	public ArrayList<ServantBean> special() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants WHERE category_id = 'C075'";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("specialで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 特殊 */
	public ArrayList<ServantBean> legend() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants WHERE category_id = 'C099'";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {

				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("legendで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 安い順 */
	public ArrayList<ServantBean> sortPriceA() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants ORDER BY price ASC;";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sortPriceAで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 高い順 */
	public ArrayList<ServantBean> sortPriceD() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants ORDER BY price DESC;";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sortPriceDで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 弱い順 */
	public ArrayList<ServantBean> sortPowerA() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants ORDER BY power ASC;";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sortPowerAで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

	/* 弱い順 */
	public ArrayList<ServantBean> sortPowerD() {
		// 実行結果を格納する変数
		ResultSet rs = null;
		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行  「""」→java 「''」→SQL
			String SQL = "SELECT * FROM servants ORDER BY power DESC;";

			rs = DBUtil.execute(SQL);

			ArrayList<ServantBean> list = new ArrayList<ServantBean>();

			rs.beforeFirst();

			while (rs.next()) {
				ServantBean servantBean = new ServantBean();

				servantBean.setId(rs.getString("servant_id"));
				servantBean.setName(rs.getString("name"));
				servantBean.setPrice(rs.getString("price"));
				servantBean.setPower(rs.getString("power"));
				servantBean.setCategory(rs.getString("category_id"));
				servantBean.setExplanation(rs.getString("explanation"));
				servantBean.setImage(rs.getString("image"));

				list.add(servantBean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sortPowerDで例外が発生しました");
			return null;

		} finally {
			DBUtil.closeConnection();
		}

	}

}

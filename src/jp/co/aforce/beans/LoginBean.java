package jp.co.aforce.beans;

import java.io.Serializable;

public class LoginBean implements Serializable {
	// static final long serialVersionUIDが必要
    private static final long serialVersionUID = 1L;

    // フィールド(メンバ変数)の宣言
    private String username;
    private String password;
    private String emsg;

    // 引数なしのデフォルトコンストラクタ
    public LoginBean() {
    }

    // usernameフィールドのsetter,gette
    // 返り値の型 メソッド名(引数の型 引数名) {メソッドの処理}
    public String getUsername() {
    	return this.username;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    // passwordフィールドのsetter,getter
    public String getPassword() {
    	return this.password;
    }


    public void setPassword(String password) {
    	this.password = password;
    }

    // emsgフィールドのsetter,getter
    public String getEmsg() {
    	return this.emsg;
    }

    public void setEmsg(String emsg) {
     	this.emsg = emsg;
    }

}

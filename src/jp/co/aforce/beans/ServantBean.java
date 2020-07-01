package jp.co.aforce.beans;

import java.io.Serializable;

public class ServantBean implements Serializable {
	// static final long serialVersionUIDが必要
    private static final long serialVersionUID = 1L;


    // フィールド(メンバ変数)の宣言
    private String id;
    private String name;
    private String price;
    private String power;
    private String category;
    private String explanation;
    private String image;

	private String search;
    private String emsg;
    private String quantity;

	// setter,getter 返り値の型 メソッド名(引数の型 引数名) {メソッドの処理}
    public String getId() {
    	return this.id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    }

    public String getPrice() {
    	return this.price;
    }

    public void setPrice(String price) {
    	this.price = price;
    }

    public String getPower() {
    	return this.power;
    }

    public void setPower(String power) {
    	this.power = power;
    }

    public String getCategory() {
    	return this.category;
    }

    public void setCategory(String category) {
    	this.category = category;
    }

    public String getExplanation() {
    	return this.explanation;
    }

    public void setExplanation(String explanation) {
    	this.explanation = explanation;
    }


    public String getSearch() {
    	return this.search;
    }

    public void setSearch(String search) {
    	this.search = search;
    }

    public String getEmsg() {
 	    return this.emsg;
    }

    public void setEmsg(String emsg) {
 	    this.emsg = emsg;
    }

    public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

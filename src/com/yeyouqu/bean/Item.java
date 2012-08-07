package com.yeyouqu.bean;

/**
 * 登记商品实体
 * 
 * @author yangq(qi.yang.cn@gmail.com) 2012-8-1
 */
public class Item {

	private String name;// 物品名称
	private Long number;// 物品数量
	private String price;// 物品价格
	private String picUrl;// 图片链接

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}

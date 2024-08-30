package com.entity;


import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class movies {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private String mname;
	private String language;
	private int price;
	private int qty;
	private String date;
	
	public movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public movies(int mid, String mname, String language, int price, int qty, String date) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.language = language;
		this.price = price;
		this.qty = qty;
		this.date = date;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}

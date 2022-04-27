package com.example.nftmarket;

public class MyCartModel {

	String productName;
	String productPrice;
	String currentDate;
	String currentTime;
	String totalQuantity;
	int totalPrice;
	
	public MyCartModel() {
	}
	
	public MyCartModel(String productName, String productPrice, String currentDate, String currentTime, String totalQuantity, String totalQuantity){
		this.productName = productName;
		this.productPrice = productPrice;
		this.currentDate = currentDate;
		this.currentTime = currentTime;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		
	}
	
	public String getproductName() {
		return productName;
	}
	
	public void setproductName( String productName) {
		this.productName = productName;
	}	
	
	public String getproductPrice() {
		return productPrice;
	}
	
	public void setproductPrice( String productPrice) {
		this.productPrice = productPrice;
	}	
	
	public String getcurrentDate() {
		return currentDate;
	}
	
	public void setcurrentDate( String currentDate) {
		this.currentDate = currentDate;
	}	
	
	public String getcurrentTime() {
		return currentTime;
	}
	
	public void setcurrentTime( String currentTime) {
		this.currentTime = currentTime;
	}	
	
	public String gettotalQuantity() {
		return totalQuantity;
	}
	
	public void settotalQuantity( String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}	
	
	public int gettotalPrice() {
		return totalPrice;
	}
	
	public void settotalPrice( int totalPrice) {
		this.totalPrice = totalPrice;
	}	

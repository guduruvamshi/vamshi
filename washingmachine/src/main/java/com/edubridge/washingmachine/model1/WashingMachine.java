package com.edubridge.washingmachine.model1;

public class WashingMachine {
	 private int modelno;
	 private String brand;
	 private float price;
	 private float rating;
	 private String  warrenty;
	 
	public int getModelno() {
		return modelno;
	}
	
	public void setModelno(int modelno) {
		this.modelno = modelno;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}
	public void setPrice(Float newPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "WashingMachine [modelno=" + modelno + ", brand=" + brand + ", price=" + price + ", rating=" + rating
				+ ", warrenty=" + warrenty + "]";
	}
	 

}

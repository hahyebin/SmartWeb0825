package com.koreait.ex04.domain;

public class Product {
	
	//field
	private String mName;
	private int price;
	
	// getter
	public String getmName() {
		return mName;
	}
	public int getPrice() {
		return price;
	}
	
	// constructor
	private Product(Builder builder) {
		this.mName = builder.mName;
		this.price = builder.price;
	
	}
	
	
	// Product 의 내부클래스 Builder
	public static class Builder {
		private String mName;  // 선택 필드기 때문에 디폴트 생성자  만듦
		private int price;
		
		// constructor 
		public Builder() {
			
		}
		
		
		// setter
		public Builder setmName(String mName) {
			this.mName = mName;
			return this;
		}
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}
		
		
		// Product객체 반환하는 build()메서드
		public Product build() {
			return new Product(this);
		}
		
	}
	
}

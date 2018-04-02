package com.sk.sheikhpura.model;


public class CartLineInfo {
 
    private ProductInfoForImage productInfoForImage;
    private int quantity;
 
    public CartLineInfo() {
        this.quantity = 0;
    }
 
    public ProductInfoForImage getProductInfoForImage() {
		return productInfoForImage;
	}

	public void setProductInfoForImage(ProductInfoForImage productInfoForImage) {
		this.productInfoForImage = productInfoForImage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
        return this.productInfoForImage.getPrice() * this.quantity;
    }
}

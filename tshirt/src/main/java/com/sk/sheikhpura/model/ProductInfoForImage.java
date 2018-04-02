package com.sk.sheikhpura.model;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sk.sheikhpura.entity.Product;

 
public class ProductInfoForImage {
	
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    
    private String shortDesc;
    private String longDesc;
    private String category;
 
    private boolean newProduct=false;
    
    private CommonsMultipartFile fileOne;
    private CommonsMultipartFile fileTwo;
    private CommonsMultipartFile fileThree;
    private CommonsMultipartFile fileFour;
    
    public ProductInfoForImage() {
    }
 
    public ProductInfoForImage(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity=product.getQuantity();
        this.shortDesc=product.getShortDesc();
        this.longDesc=product.getLongDesc();
        this.category=product.getCategory();
    }
 
   

	public ProductInfoForImage(Integer id, String name, double price, int quantity, String shortDesc, String longDesc,
			String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CommonsMultipartFile getFileOne() {
		return fileOne;
	}

	public void setFileOne(CommonsMultipartFile fileOne) {
		this.fileOne = fileOne;
	}

	public CommonsMultipartFile getFileTwo() {
		return fileTwo;
	}

	public void setFileTwo(CommonsMultipartFile fileTwo) {
		this.fileTwo = fileTwo;
	}

	public CommonsMultipartFile getFileThree() {
		return fileThree;
	}

	public void setFileThree(CommonsMultipartFile fileThree) {
		this.fileThree = fileThree;
	}

	public CommonsMultipartFile getFileFour() {
		return fileFour;
	}

	public void setFileFour(CommonsMultipartFile fileFour) {
		this.fileFour = fileFour;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public boolean isNewProduct() {
        return newProduct;
    }
 
}
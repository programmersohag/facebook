package com.sk.sheikhpura.dao;

import java.util.List;

import com.sk.sheikhpura.model.ProductInfo;

public interface ProductDao {
	
	ProductInfo findProductInfo(Integer id);
	
	List<ProductInfo> findAll();
	
	int addProduct(ProductInfo entity);
	
	int updateProduct(ProductInfo entity);
	
	int deleteProduct(Integer id);
	//display image
	
	
}

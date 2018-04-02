package com.sk.sheikhpura.dao;

import java.util.List;

import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.model.PaginationResult;
import com.sk.sheikhpura.model.ProductInfoForImage;

public interface ProductDaoForImage {

	public Product findProduct(Integer id);

	public List<Product> getAllProducts();
	

	public ProductInfoForImage findProductInfo(Integer code);

	public PaginationResult<ProductInfoForImage> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfoForImage> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

	public void save(ProductInfoForImage productInfo);
}

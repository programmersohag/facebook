package com.sk.sheikhpura.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sheikhpura.dao.ProductDaoForImage;
import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.model.PaginationResult;
import com.sk.sheikhpura.model.ProductInfoForImage;


@Transactional
@Repository
public class ProductImageDaoImpl implements ProductDaoForImage {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product findProduct(Integer id) {
		Session session = sessionFactory.openSession();
		//sessionFactory.getCurrentSession().get(Product.class, id);
		return (Product) session.load(Product.class, new Integer(id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> producstList = session.createQuery("from Products").list();
		return producstList;
	}

	@Override
	public ProductInfoForImage findProductInfo(Integer id) {
		Product p = this.findProduct(id);
		if (p == null) {
			return null;
		}
		return new ProductInfoForImage(p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getShortDesc(), p.getLongDesc(), p.getCategory());
	}

	@Override
	public PaginationResult<ProductInfoForImage> queryProducts(int page, int maxResult, int maxNavigationPage) {
		return queryProducts(page, maxResult, maxNavigationPage, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PaginationResult<ProductInfoForImage> queryProducts(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + ProductInfoForImage.class.getName() 
				+ "(p.id, p.name, p.price, p.quantity, p.shortDesc, p.longDesc, p.category) " + " from "
				+ Product.class.getName() + " p ";
		if (likeName != null && likeName.length() > 0) {
			sql += " Where lower(p.name) like :likeName ";
		}
		
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		if (likeName != null && likeName.length() > 0) {
			query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
		}
		return new PaginationResult<ProductInfoForImage>(query, page, maxResult, maxNavigationPage);
	}

	@Override
	public void save(ProductInfoForImage productInfoForImage) {
		Integer id = productInfoForImage.getId();

		Product product = null;

		boolean isNew = false;
		if (id != null) {
			product = this.findProduct(id);
		}
		if (product == null) {
			isNew = true;
			product = new Product();
		//	product.setCreateDate(new Date());
		}
		product.setId(id);
		product.setName(productInfoForImage.getName());
		product.setShortDesc(productInfoForImage.getShortDesc());
		product.setLongDesc(productInfoForImage.getLongDesc());
		product.setPrice(productInfoForImage.getPrice());
		product.setQuantity(productInfoForImage.getQuantity());
		

		if (productInfoForImage.getFileOne() != null) {
			byte[] imageOne = productInfoForImage.getFileOne().getBytes();
			if (imageOne != null && imageOne.length > 0) {
				product.setImageOne(imageOne);
			}
		}
		if (productInfoForImage.getFileTwo() != null) {
			byte[] imageTwo = productInfoForImage.getFileTwo().getBytes();
			if (imageTwo != null && imageTwo.length > 0) {
				product.setImageTwo(imageTwo);
			}
		}
		if (productInfoForImage.getFileThree() != null) {
			byte[] imageThree = productInfoForImage.getFileThree().getBytes();
			if (imageThree != null && imageThree.length > 0) {
				product.setImageThree(imageThree);
			}
		}
		if (productInfoForImage.getFileFour() != null) {
			byte[] imageFour = productInfoForImage.getFileFour().getBytes();
			if (imageFour != null && imageFour.length > 0) {
				product.setImageFour(imageFour);
			}
		}
		if (isNew) {
			this.sessionFactory.getCurrentSession().persist(product);
		}
		this.sessionFactory.getCurrentSession().flush();
	}

}

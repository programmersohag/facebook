package com.sk.sheikhpura.controller.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.sheikhpura.dao.ProductDaoForImage;
import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.model.ShoppingCart;

@Controller
//@SessionAttributes("mycounter")
public class CartController {

	@Autowired
	private ProductDaoForImage dao;
	
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
	}
	
	@RequestMapping(value="addToCart" , method = RequestMethod.GET)
	public String showCart(HttpServletRequest request){
		try {
			Integer id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (Exception e) {
			e.getMessage();
		}
		
		//Product p=dao.findProduct(id);
		System.out.println("Hello");
	   //ShoppingCart cart = (ShoppingCart)request.getSession().setAttribute("cart",value);
	   return "cart";
	}
	
	@RequestMapping(value="addToCart", method = RequestMethod.POST)
	public String addToCart(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));
		Product p=dao.findProduct(id);
		System.out.println(id);
		if(p!=null){
			ShoppingCart entity=new ShoppingCart();
			//entity.setProductId(request.getParameter("id"));
			entity.setProductName(request.getParameter("price"));
			entity.setProductQuantity(request.getParameter("quantity"));
			entity.setProductPrice(request.getParameter("size"));
				
			List<ShoppingCart> cartList=new ArrayList<ShoppingCart>();
			cartList.add(entity);
			System.out.println("New Product");
			System.out.println("List "+cartList);
			request.getSession().setAttribute("cart", cartList);
			
			return "cart";
		}
		
		return "redirect:/cart";
				
	}
	
}

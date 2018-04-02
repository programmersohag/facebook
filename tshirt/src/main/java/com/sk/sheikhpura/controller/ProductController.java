package com.sk.sheikhpura.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sk.sheikhpura.dao.ProductDaoForImage;
import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.model.PaginationResult;
import com.sk.sheikhpura.model.ProductInfoForImage;

@Controller
public class ProductController {

	@Autowired
	private ProductDaoForImage dao;

	// @Autowired
	// private ResourceBundleMessageSource messageSource;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

		if (target.getClass() == ProductInfoForImage.class) {
			// dataBinder.setValidator(productInfoValidator);
			// For upload Image.
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "id", defaultValue = "") Integer id) {
		ProductInfoForImage productInfo = null;

		if (id != null && id > 0) {
			productInfo = dao.findProductInfo(id);
		}
		if (productInfo == null) {
			productInfo = new ProductInfoForImage();
			productInfo.setNewProduct(true);
		}
		model.addAttribute("productForm", productInfo);
		return "product";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	// Avoid UnexpectedRollbackException (See more explanations)
	@Transactional(propagation = Propagation.NEVER)
	public String productSave(Model model, @ModelAttribute("productForm") @Validated ProductInfoForImage productInfo,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "product";
		}
		try {
			dao.save(productInfo);
		} catch (Exception e) {
			String message = e.getMessage();
			model.addAttribute("message", message);
			return "product";
		}
		return "redirect:/productList";
	}

	@RequestMapping(value= "/productList")
	public String listProductHandler(Model model, @RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 20;
		final int maxNavigationPage = 20;
		PaginationResult<ProductInfoForImage> result = dao.queryProducts(page, maxResult,
				maxNavigationPage, likeName);
		model.addAttribute("paginationProducts", result);
		return "productList";
	}

	@RequestMapping("/product_details")
	public String productDetails(Model model, @RequestParam("id") Integer id) {

		Product product = null;
		// if (id != null) {
		product = dao.findProduct(id);

		model.addAttribute("id", product.getId());
		model.addAttribute("name", product.getName());
		model.addAttribute("shortDesc", product.getShortDesc());
		model.addAttribute("longDesc", product.getLongDesc());
		model.addAttribute("price", product.getPrice());
		model.addAttribute("quantity", product.getQuantity());
		System.out.println(model);
		return "productDetails";
		// }

		/*
		 * if (product != null) {
		 * 
		 * // Cart info stored in Session. CartInfo cartInfo =
		 * Utils.getCartInSession(request);
		 * 
		 * ProductInfoForImage productInfo = new ProductInfoForImage(product);
		 * 
		 * cartInfo.addProduct(productInfo, 1); }
		 */ // return "redirect:/productDetails";
	}

	@RequestMapping(value = "/image_one", method = RequestMethod.GET)
	public void productImageOne(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") Integer id) throws IOException {
		Product product = null;
		if (id != null) {
			product = this.dao.findProduct(id);
		}
		if (product != null && product.getImageOne() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImageOne());
		}
		response.getOutputStream().close();
	}

	@RequestMapping(value = "/image_two", method = RequestMethod.GET)
	public void getImageThree(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") Integer id) throws IOException {
		Product product = null;
		if (id != null) {
			product = this.dao.findProduct(id);
		}

		if (product != null && product.getImageTwo() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImageTwo());
		}
		response.getOutputStream().close();
	}

	@RequestMapping(value = "/image_three", method = RequestMethod.GET)
	public void getImageOne(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") Integer id) throws IOException {
		Product product = null;
		if (id != null) {
			product = this.dao.findProduct(id);
		}

		if (product != null && product.getImageThree() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImageThree());
		}
		response.getOutputStream().close();
	}

	@RequestMapping(value = "/image_four", method = RequestMethod.GET)
	public void getImageTwo(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") Integer id) throws IOException {
		Product product = null;
		if (id != null) {
			product = this.dao.findProduct(id);
		}

		if (product != null && product.getImageFour() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImageFour());
		}
		response.getOutputStream().close();
	}
	
	@RequestMapping(value="add_to_cart" , method = RequestMethod.GET)
	public String showProductCart(HttpServletRequest request){
		System.out.println("Hello");
	   //ShoppingCart cart = (ShoppingCart)request.getSession().setAttribute("cart",value);
	   return "cart";
	}

}

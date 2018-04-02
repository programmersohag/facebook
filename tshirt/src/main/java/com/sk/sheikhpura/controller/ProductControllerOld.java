package com.sk.sheikhpura.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.sk.sheikhpura.dao.ProductDao;
import com.sk.sheikhpura.model.ProductInfo;
import com.sk.sheikhpura.utils.JsonUtil;

@Controller
@RequestMapping("product")
public class ProductControllerOld {

	@Autowired
	private ProductDao dao;

/*	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == Product.class) {
			// dataBinder.setValidator(productInfoValidator);
			// For upload Image.
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}*/

	@RequestMapping(value = "/productForm", method = RequestMethod.GET)
	public String create(Model model, ProductInfo product) {
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@Validated @ModelAttribute("product") ProductInfo product,  MultipartFile file)
			throws Exception {
		file=product.getImage();
		if (product.isNew()) {
			product.setFileType(file.getContentType());
			product.setFileName(file.getOriginalFilename());
			product.setInsDate(new Date());
			dao.addProduct(product);
			
			} else {
				product.setId(product.getId());
				product.setUpdDate(new Date());
				dao.updateProduct(product);
			}
		return "redirect:/product/list";
	}


	@RequestMapping(value = "/save-success", method = RequestMethod.GET)
	public String saveProduct(Model model) {
		
		model.addAttribute("product", new ProductInfo());
		return "save-success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String readProduct(Model model, HttpServletResponse response){
		response.setContentType("image/jpg");
		List<ProductInfo> list = dao.findAll();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateProduct(@PathVariable("id") int id, Model model, ProductInfo product){
		
		// to show value in text filed in jsp
		ProductInfo entity = dao.findProductInfo(id);
		model.addAttribute("product", entity);
		//model.addAttribute("product", new ProductInfo());
		model.addAttribute("name", product.getName());
		model.addAttribute("short-desc", product.getShortDesc());
		model.addAttribute("long-desc", product.getLongDesc());
		model.addAttribute("price", product.getPrice());
		model.addAttribute("quantity", product.getQuantity());
		return "addProduct";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable("id") int id, Model model, ProductInfo product){
		dao.deleteProduct(id);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "get/data", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getProductData(NativeWebRequest request) throws JSONException {

		JSONObject jObject = new JSONObject();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			System.out.printf("ID=%d ", id);
			ProductInfo entity = dao.findProductInfo(id);
			jObject.put("name", entity.getName());
			jObject.put("short-desc", entity.getShortDesc());
			jObject.put("long-desc", entity.getLongDesc());
			jObject.put("price", entity.getPrice());
			jObject.put("quantity", entity.getQuantity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonUtil.json(jObject);
	}
	
	 @RequestMapping(value ="/product_image", method = RequestMethod.GET)
	 public String showImage() {
		 System.out.println("Show Image");
		 return "showImg";
	 }
	
    @RequestMapping(value ="/productImage", method = RequestMethod.GET)
    public void productImage(HttpServletResponse response, Model model, Integer id) throws IOException {
    	id=82;//(Integer) request.getAttribute("productId");
    	ProductInfo image = dao.findProductInfo(id);
    	
    	 if (image.getImage2() != null) {
             response.setContentType(image.getFileType());
             response.setContentLength((int) image.getImage().getSize());
             
             try {
                 response.getOutputStream().write((int) image.getImage().getSize());
                 response.getOutputStream().flush();
                 response.getOutputStream().close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
}
	
}

package com.sk.sheikhpura.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sk.sheikhpura.dao.ProductDaoForImage;
import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.model.ProductInfoForImage;



// @Component: As a Bean.
@Component
public class ProductInfoValidator implements Validator {

	@Autowired
	private ProductDaoForImage productDaoForImage;

	// This Validator support ProductInfo class.
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == ProductInfoForImage.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductInfoForImage productInfoForImage = (ProductInfoForImage) target;

		// Check the fields of ProductInfo class.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

		String code = productInfoForImage.getId().toString();
		if (code != null && code.length() > 0) {
			if (code.matches("\\s+")) {
				errors.rejectValue("code", "Pattern.productForm.code");
			} else if (productInfoForImage.isNewProduct()) {
				//Product product = productDaoForImage.findProduct(code);
				//if (product != null) {
					errors.rejectValue("code", "Duplicate.productForm.code");
				}
			}
		}
	//}

}
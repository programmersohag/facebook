package com.sk.sheikhpura.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sk.sheikhpura.dao.UserDao;
import com.sk.sheikhpura.entity.UserInfo;


@Component
public class UserInfoValidator implements Validator {
    @Autowired
    private UserDao userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.equals(aClass);
    }
    @Override
    public void validate(Object o, Errors errors) {
    	 UserInfo user = (UserInfo) o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
         if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
             errors.rejectValue("userName", "USerName Not Valid");
         }
         if (userService.findUserByUserName(user.getUserName()) != null) {
             errors.rejectValue("userName", "Duplicate.userForm.userName");
         }
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
         if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
             errors.rejectValue("password", "Size.userForm.password");
         }
         if (!user.getPassword().equals(user.getPassword())) {
             errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
         }
    }

}

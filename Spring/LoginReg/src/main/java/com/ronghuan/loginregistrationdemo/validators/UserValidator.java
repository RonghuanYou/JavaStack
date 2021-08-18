package com.ronghuan.loginregistrationdemo.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ronghuan.loginregistrationdemo.models.User;
import com.ronghuan.loginregistrationdemo.services.MainService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private MainService mainServ;

	@Override
	public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
	}

	// Custom validations, add error messages via rejectValue
	// rejectValue(member variable in User model to validate, to set a error message)
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		// CHECK IF CONFIRM PASSWORD AND INPUT PASSWORD MATCH
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
        }    		
		
		// CHECK UNIQUE EMAIL
		if (mainServ.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate");
		}
	}
	

}

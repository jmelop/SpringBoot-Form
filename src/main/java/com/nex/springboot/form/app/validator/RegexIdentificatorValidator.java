package com.nex.springboot.form.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexIdentificatorValidator implements ConstraintValidator<RegexIdentificator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[0-9]{4}[.][\\d]{3}")) {
			return true;
		}
		return false;
	}

}

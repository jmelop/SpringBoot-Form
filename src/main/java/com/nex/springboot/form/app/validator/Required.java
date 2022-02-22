package com.nex.springboot.form.app.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RequireValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Required {
	String message() default "Field is required";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

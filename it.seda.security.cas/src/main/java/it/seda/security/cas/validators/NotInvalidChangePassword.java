package it.seda.security.cas.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordChangedValidator.class)
@Documented
public @interface NotInvalidChangePassword {

	
	 String message() default "{it.seda.sem.security.password.invalidpassword}";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 String field();
}

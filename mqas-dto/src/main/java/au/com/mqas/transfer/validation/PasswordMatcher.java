package au.com.mqas.transfer.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import au.com.mqas.transfer.validation.validator.PasswordMatcherValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = PasswordMatcherValidator.class)
public @interface PasswordMatcher {
    
   String message() default "Passwords do not match";
   
   Class<?>[] groups() default {};
   
   Class<? extends Payload>[] payload() default {};

}

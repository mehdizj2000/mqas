package au.com.mqas.transfer.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import au.com.mqas.transfer.data.dto.LoginUserDto;
import au.com.mqas.transfer.validation.PasswordMatcher;

public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatcher, LoginUserDto> {

    @Override
    public void initialize(PasswordMatcher constraintAnnotation) {
	// TODO Auto-generated method stub
//	ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoginUserDto value, ConstraintValidatorContext context) {
	boolean isValid = StringUtils.equals(value.getPassword(), value.getPasswordConfirmation());
//	if (!isValid) {
//	    context.disableDefaultConstraintViolation();
//	    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
//		    .addPropertyNode("matchingPassword").addConstraintViolation();
//	}
	return isValid;
    }

}

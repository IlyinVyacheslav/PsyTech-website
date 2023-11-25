package ru.itmo.wp.form.validator;
//TODO: избавиться от этой темы
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidAge, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value < 25 || value > 100) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid age: " + (value) + ", must be between 25 and 100")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}

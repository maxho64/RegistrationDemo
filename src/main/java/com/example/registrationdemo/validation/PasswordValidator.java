package com.example.registrationdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null &&
                contactField.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})")
                && (contactField.length() > 8);
    }
}
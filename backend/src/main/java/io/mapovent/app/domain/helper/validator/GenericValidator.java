package io.mapovent.app.domain.helper.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.Validation;

public class GenericValidator implements Validator {

    @Autowired
    protected Validator basicValidator;


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
    }

    private void init() {
        if (basicValidator == null) {
            basicValidator = new SpringValidatorAdapter(Validation.buildDefaultValidatorFactory().getValidator());
        }
    }

    public void validateJsr(Object object, Errors errors) {
        init();
        basicValidator.validate(object, errors);
    }
}

package io.mapovent.app.domain.helper.entity;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationException extends Exception {

    private final List<ObjectError> objectErrorList;


    public ValidationException(List<ObjectError> objectErrorList) {
        this.objectErrorList = objectErrorList;
    }

    public List<ObjectError> getObjectErrorList() {
        return objectErrorList;
    }

}

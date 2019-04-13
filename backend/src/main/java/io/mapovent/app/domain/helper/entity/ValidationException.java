package io.mapovent.app.domain.helper.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationException extends Exception {

    private final List<ObjectError> objectErrorList;
}

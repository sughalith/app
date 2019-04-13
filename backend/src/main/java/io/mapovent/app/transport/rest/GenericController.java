package io.mapovent.app.transport.rest;

import io.mapovent.app.domain.helper.entity.ValidationException;
import io.mapovent.app.domain.user.entity.User;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

public abstract class GenericController {

  protected User getCurrentUser() {
    return User.builder().build();
  }

  protected void validate(Object data, Validator validator) throws ValidationException {
    DataBinder dataBinder = new DataBinder(data);
    dataBinder.setValidator(validator);

    dataBinder.validate();
    if (dataBinder.getBindingResult().hasErrors()) {
      throw new ValidationException(dataBinder.getBindingResult().getAllErrors());
    }
  }
}

package io.mapovent.app.domain.event.validator;

import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.helper.validator.GenericValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator extends GenericValidator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event) o;
        validateJsr(event, errors);
    }


}

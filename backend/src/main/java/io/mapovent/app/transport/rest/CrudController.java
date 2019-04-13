package io.mapovent.app.transport.rest;

import io.mapovent.app.domain.helper.FilterElement;
import io.mapovent.app.domain.helper.entity.ValidationException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudController<T> {

  ResponseEntity<T> find(String id);

  ResponseEntity<List<T>> find(Optional<List<FilterElement>> filterBy);

  ResponseEntity<String> create(T entity) throws ValidationException;

  ResponseEntity<T> update(String id, T entity);

  ResponseEntity delete(String id);

}

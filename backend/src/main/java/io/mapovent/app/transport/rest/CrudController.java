package io.mapovent.app.transport.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T> {

  ResponseEntity<T> find(String id);

  ResponseEntity<List<T>> find(List<String> filterBy);

  ResponseEntity<T> create(T entity);

  ResponseEntity<T> update(String id, T entity);

  void delete(String id);

}

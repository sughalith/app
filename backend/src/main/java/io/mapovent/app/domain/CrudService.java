package io.mapovent.app.domain;

import io.mapovent.app.domain.helper.FilterElement;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

  Optional<T> find(String id);

  List<T> find(Optional<List<FilterElement>> filterBy);

  String create(T entity);

  T update(String id, T entity);

  void delete(String id);

}

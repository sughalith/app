package io.mapovent.app.transport.rest;

import java.util.List;

public interface CrudController<T> {

  T find(String id);

  List<T> find(List<String> filterBy);

  String create(T entity);

  void update(String id, T entity);

  void delete(String id);

}

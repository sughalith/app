package io.mapovent.app.transport.rest;

import io.mapovent.app.domain.user.entity.User;

public abstract class GenericController {

  protected User getCurrentUser() {
    return new User();
  }
}

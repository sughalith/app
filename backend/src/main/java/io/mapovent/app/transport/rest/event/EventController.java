package io.mapovent.app.transport.rest.event;

import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.user.entity.User;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController extends GenericController implements CrudController<Event> {


  @RequestMapping(value = "/{id}")
  public Event find(@PathVariable("id") String id) {
    return null;
  }

  @RequestMapping()
  public List<Event> find(@RequestParam List<String> filterBy) {
    return null;
  }

  public String create(Event entity) {
    return null;
  }

  public void update(String id, Event entity) {

  }

  public void delete(String id) {
  }
}

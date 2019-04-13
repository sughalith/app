package io.mapovent.app.transport.rest.event;

import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.event.service.EventService;
import io.mapovent.app.domain.user.entity.User;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController extends GenericController implements CrudController<Event> {

  private final EventService eventService;

  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping(value = "/{id}")
  public Event find(@PathVariable("id") String id) {
    return null;
  }

  @GetMapping()
  public List<Event> find(@RequestParam List<String> filterBy) {
    return null;
  }

  @PostMapping()
  public String create(Event entity) {
    Event event = Event.builder().description("123123").build();
    return eventService.create(event);
  }

  public void update(String id, Event entity) {

  }

  public void delete(String id) {
  }
}

package io.mapovent.app.transport.rest.event;

import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.event.service.EventService;
import io.mapovent.app.domain.helper.FilterElement;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/event")
public class EventController extends GenericController implements CrudController<Event> {

  private final EventService eventService;

  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Event> find(@PathVariable("id") String id) {
    Optional<Event> event = eventService.find(id);
    return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
      -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping()
  public ResponseEntity<List<Event>> find(@RequestParam Optional<List<FilterElement>> filterBy) {
    return new ResponseEntity<>(eventService.find(filterBy), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<String> create(Event entity) {
    try {
      return new ResponseEntity<>(eventService.create(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }

  public ResponseEntity<Event> update(String id, Event entity) {
    try {
      return new ResponseEntity<>(eventService.update(id, entity), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity delete(String id) {
    try {
      eventService.delete(id);
      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}

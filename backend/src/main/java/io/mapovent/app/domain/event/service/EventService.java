package io.mapovent.app.domain.event.service;

import io.mapovent.app.domain.event.dao.EventRepository;
import io.mapovent.app.domain.event.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
  private final EventRepository eventRepository;

  @Autowired
  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public String create(Event event) {
    return eventRepository.insert(event).getId();
  }
}

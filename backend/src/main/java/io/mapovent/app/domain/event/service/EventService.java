package io.mapovent.app.domain.event.service;

import io.mapovent.app.domain.repository.EventRepository;
import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.repository.sequencegenerator.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
  private final EventRepository eventRepository;
  private final SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  public EventService(EventRepository eventRepository, SequenceGeneratorService sequenceGeneratorService) {
    this.eventRepository = eventRepository;
    this.sequenceGeneratorService = sequenceGeneratorService;
  }

  public String create(Event event) {
    Event eventGen = Event.builder().id(sequenceGeneratorService.generateSequence("event_seq"))
      .description("Desc").build();
    return eventRepository.insert(eventGen).getId();
  }
}

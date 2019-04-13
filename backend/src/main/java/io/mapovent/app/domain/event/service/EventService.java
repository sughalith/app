package io.mapovent.app.domain.event.service;

import io.mapovent.app.domain.event.entity.Event;
import io.mapovent.app.domain.helper.FilterElement;
import io.mapovent.app.domain.helper.QueryService;
import io.mapovent.app.domain.repository.EventRepository;
import io.mapovent.app.domain.repository.sequencegenerator.SequenceGeneratorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EventService {
  private final EventRepository eventRepository;
  private final SequenceGeneratorService sequenceGeneratorService;
  private final QueryService queryService;
  private final MongoTemplate mongoTemplate;

  public EventService(EventRepository eventRepository, SequenceGeneratorService sequenceGeneratorService,
                      QueryService queryService, MongoTemplate mongoTemplate) {
    this.eventRepository = eventRepository;
    this.sequenceGeneratorService = sequenceGeneratorService;
    this.queryService = queryService;
    this.mongoTemplate = mongoTemplate;
  }

  public String create(Event event) {
    Event eventGen = event.toBuilder().id(sequenceGeneratorService.generateSequence("event_seq")).build();
    return eventRepository.insert(eventGen).getId();
  }

  public Optional<Event> find(String id) {
    return eventRepository.findById(id);
  }

  public List<Event> find(Optional<List<FilterElement>> filterElements) {
    if (filterElements.isPresent()) {
      Query query = queryService.find(filterElements.get());
      return mongoTemplate.find(query, Event.class);
    } else {
      return eventRepository.findAll();
    }
  }

  public Event update(String id, Event entity) {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isPresent()) {
      return eventRepository.save(entity);
    } else {
      //TODO change to exception throw
      return null;
    }
  }

  public void delete(String id) {
    try {
      eventRepository.deleteById(id);
    } catch (Exception e) {
      log.error(e);
    }
  }
}

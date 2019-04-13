package io.mapovent.app.domain.user.service;

import com.mongodb.MongoException;
import io.mapovent.app.domain.CrudService;
import io.mapovent.app.domain.helper.FilterElement;
import io.mapovent.app.domain.helper.QueryService;
import io.mapovent.app.domain.repository.UserRepository;
import io.mapovent.app.domain.repository.sequencegenerator.SequenceGeneratorService;
import io.mapovent.app.domain.user.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService implements CrudService<User> {

  private final UserRepository userRepository;
  private final QueryService queryService;
  private final SequenceGeneratorService sequenceGeneratorService;
  private final MongoTemplate mongoTemplate;

  public UserService(UserRepository userRepository, QueryService queryService,
                     SequenceGeneratorService sequenceGeneratorService, MongoTemplate mongoTemplate) {
    this.userRepository = userRepository;
    this.queryService = queryService;
    this.sequenceGeneratorService = sequenceGeneratorService;
    this.mongoTemplate = mongoTemplate;
  }

  public Optional<User> find(String id) {
    return userRepository.findById(id);
  }

  public List<User> find(Optional<List<FilterElement>> filterElements) {
    if (filterElements.isPresent()) {
      Query query = queryService.find(filterElements.get());
      return mongoTemplate.find(query, User.class);
    } else {
      return userRepository.findAll();
    }
  }

  public String create(User entity) {
    User userGen = entity.toBuilder().id(sequenceGeneratorService.generateSequence("user_seq")).build();
    return userRepository.insert(userGen).getId();
  }

  public User update(String id, User entity) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      User newEntity = entity.toBuilder().id(user.get().getId()).build();
      return userRepository.save(newEntity);
    } else {
      throw new MongoException("Not found");
    }
  }

  public void delete(String id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      userRepository.delete(user.get());
    } else {
      throw new MongoException("Not found");
    }
  }
}

package io.mapovent.app.transport.rest.user;

import com.mongodb.MongoException;
import io.mapovent.app.domain.helper.FilterElement;
import io.mapovent.app.domain.user.entity.User;
import io.mapovent.app.domain.user.service.UserService;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericController implements CrudController<User> {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @RequestMapping("/{id}")
  public ResponseEntity<User> find(@PathVariable("id") String id) {
    Optional<User> user = userService.find(id);
    return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
      -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<List<User>> find(@RequestParam Optional<List<FilterElement>> filterBy) {
    return new ResponseEntity<>(userService.find(filterBy), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<String> create(@RequestBody User entity) {
    try {
      return new ResponseEntity<>(userService.create(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> update(@PathVariable("id") String id, @RequestBody User entity) {
    try {
      return new ResponseEntity<>(userService.update(id, entity), HttpStatus.OK);
    } catch (MongoException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    try {
      userService.delete(id);
      return new ResponseEntity(HttpStatus.OK);
    } catch (MongoException e) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}

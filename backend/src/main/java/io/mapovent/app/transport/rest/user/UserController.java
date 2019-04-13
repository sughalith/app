package io.mapovent.app.transport.rest.user;

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
@RequestMapping("/user")
public class UserController extends GenericController implements CrudController<User> {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List<User>> find(Optional<List<FilterElement>> filterBy) {
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> create(User entity) {
        return new ResponseEntity("1", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(String id, User entity) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(String id) {

        return new ResponseEntity(HttpStatus.OK);
    }
}

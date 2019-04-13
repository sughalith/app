package io.mapovent.app.transport.rest.user;

import io.mapovent.app.domain.user.entity.User;
import io.mapovent.app.domain.user.service.UserService;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return null;
    }

    @GetMapping
    public ResponseEntity<List<User>> find(List<String> filterBy) {
        return null;
    }

    @PostMapping
    public ResponseEntity<User> create(User entity) {
        return null;
    }

    @PutMapping
    public ResponseEntity<User> update(String id, User entity) {
        return null;
    }

    @DeleteMapping
    public void delete(String id) {

    }
}

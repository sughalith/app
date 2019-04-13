package io.mapovent.app.transport.rest.user;

import io.mapovent.app.domain.user.entity.User;
import io.mapovent.app.transport.rest.CrudController;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends GenericController implements CrudController<User> {


    public ResponseEntity<User> find(String id) {
        return null;
    }

    public ResponseEntity<List<User>> find(List<String> filterBy) {
        return null;
    }

    public ResponseEntity<User> create(User entity) {
        return null;
    }

    public ResponseEntity<User> update(String id, User entity) {
        return null;
    }

    public void delete(String id) {

    }
}

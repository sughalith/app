package io.mapovent.app.transport.rest.user;

import io.mapovent.app.domain.user.service.UserService;
import io.mapovent.app.transport.rest.GenericController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends GenericController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity login(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity logout(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity logged(){
        return new ResponseEntity(HttpStatus.OK);
    }
}

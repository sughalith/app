package io.mapovent.app.transport.rest;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    private BuildProperties buildProperties;

    public HealthController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping
    public ResponseEntity status(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/ver")
    public ResponseEntity version(){
        return new ResponseEntity(buildProperties.getVersion(), HttpStatus.OK);
    }
}

package io.mapovent.app.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.mapovent.app.domain.event.entity.Event;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonView
@EqualsAndHashCode
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String surname;
    private String company;
    private List<Event> eventList;
    private String password;
    private String mail;
    private Boolean active;
}

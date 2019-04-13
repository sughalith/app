package io.mapovent.app.domain.user.entity;

import io.mapovent.app.domain.event.entity.Event;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class User {

    private final String name;
    private final String surname;
    private final String company;
    private final List<Event> eventList;
    private final String password;
    private final String mail;
    private final Boolean active;
}

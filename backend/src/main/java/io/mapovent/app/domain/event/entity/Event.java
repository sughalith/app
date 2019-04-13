package io.mapovent.app.domain.event.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.mapovent.app.domain.helper.entity.Views;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonView
@EqualsAndHashCode
@Document(collection = "event")
public class Event {
  @Id
  private String id;
  @JsonView(Views.Internal.class)
  private String description;
  private String title;
  private double lat;
  private double lon;
  private LocalDate startDate;
  private LocalDate endDate;
  private BigDecimal price;
  private boolean active;
  private EventType type;
  private String city;

}

enum EventType{
  RUN, GYM, YOGA, CYCLING, WALKING, SKATING
}

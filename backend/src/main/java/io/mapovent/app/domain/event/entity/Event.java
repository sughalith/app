package io.mapovent.app.domain.event.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.mapovent.app.domain.helper.entity.Views;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
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
  @NotBlank
  private String description;
  @NotBlank
  private String title;
  @NotBlank
  private double lat;
  @NotBlank
  private double lon;
  private LocalDate startDate;
  private LocalDate endDate;
  private BigDecimal price;
  private boolean active;
  private EventType type;

}

enum EventType{
  RUN, GYM, YOGA, CYCLING, WALKING, SKATING
}

package io.mapovent.app.domain.event.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Event {
  private String id;
  private String description;
  private String title;
  private double lat;
  private double lon;
  private LocalDate startDate;
  private LocalDate endDate;
  private BigDecimal price;
}

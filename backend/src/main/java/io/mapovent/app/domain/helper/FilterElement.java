package io.mapovent.app.domain.helper;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class FilterElement {

  private String key;
  private String value;

  @JsonCreator
  public FilterElement (String filterParameters){
    if(filterParameters != null && !filterParameters.isEmpty() && filterParameters.contains(":")) {
      String[] filters = filterParameters.split(":");
      this.key = filters[0];
      this.value = filters[1];
    }
    else {
      this.key = "";
      this.value = "";
    }
  }

}

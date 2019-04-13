package io.mapovent.app.domain.helper;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

  public Query find(List<FilterElement> filterElements) {
    Query query = new Query();
    filterElements.forEach(filter -> {
      query.addCriteria(Criteria.where(filter.getKey()).is(filter.getValue()));
    });
    return query;
  }
}

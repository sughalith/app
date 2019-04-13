package io.mapovent.app.domain.repository.sequencegenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {

  private final int INCREMENT = 1;
  private final String INCREMENT_STRING = "1";
  private final String ID = "_id";
  private final String SEQUENCE_KEY = "seq";

  private MongoOperations mongoOperations;

  @Autowired
  public SequenceGeneratorService(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  public String generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations.findAndModify(query(where(ID).is(seqName)),
      new Update().inc(SEQUENCE_KEY, INCREMENT), options().returnNew(true).upsert(true),
      DatabaseSequence.class);
    return !Objects.isNull(counter) ? String.valueOf(counter.getSeq()) : INCREMENT_STRING;
  }
}

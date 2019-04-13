package io.mapovent.app.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import io.mapovent.app.domain.event.entity.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.JodaTimeConverters;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = {"io.mapovent.app.domain.event.dao"})
public class DbConfig extends AbstractMongoConfiguration {

  @Value("${spring.data.mongodb.user}")
  private String user;

  @Value("${spring.data.mongodb.password}")
  private String password;

  @Value("${spring.data.mongodb.host}")
  private String host;

  @Value("${spring.data.mongodb.port}")
  private int port;

  @Value("${spring.data.mongodb.database}")
  private String dbName;


  @Override
  public String getDatabaseName() {
    return dbName;
  }

  @Override
  public MongoClient mongoClient() {
    if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)) {
      MongoCredential credential = MongoCredential.createScramSha1Credential(user, dbName, password.toCharArray());
      return new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
    }else{
      return new MongoClient(host,port);
    }
  }

  @Override
  public CustomConversions customConversions() {
    List<Converter<?, ?>> converters = new ArrayList<>();
    converters.addAll(Jsr310Converters.getConvertersToRegister());
    converters.addAll(JodaTimeConverters.getConvertersToRegister());
    return new MongoCustomConversions(converters);
  }

}

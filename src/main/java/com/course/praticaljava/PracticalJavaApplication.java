package com.course.praticaljava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@SpringBootApplication
@EnableElasticsearchRepositories
public class PracticalJavaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PracticalJavaApplication.class, args);
  }

}

/**
 *
 */
package com.course.praticaljava.common;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author Intro
 *
 */

@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration{

  /* (non-Javadoc)
   * @see org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration#elasticsearchClient()
   */
  @Override
  public RestHighLevelClient elasticsearchClient() {

    final var clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
    return RestClients.create(clientConfiguration).rest();
  }

}

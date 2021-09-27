/**
 *
 */
package com.course.praticaljava.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.course.praticaljava.entity.Car;


@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String>{

}
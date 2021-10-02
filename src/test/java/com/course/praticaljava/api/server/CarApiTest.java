package com.course.praticaljava.api.server;



import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.course.praticaljava.entity.Car;
import com.course.praticaljava.repository.CarElasticRepository;
import com.course.praticaljava.service.CarService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CarApiTest {

  @Autowired
  private WebTestClient webTestClient;

  @Autowired
  private CarElasticRepository carRepository;

  @Test
  void testRandom() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Testing loop " + i);
      webTestClient.get().uri("/api/car/v1/random").exchange().expectBody(Car.class).value(car -> {
        assertTrue(CarService.BRANDS.contains(car.getBrand()));
        assertTrue(CarService.COLORS.contains(car.getColor()));
      });
    }
  }

  @Test
  void testEcho() {

    String car = "{\"brand\":\"Mitsubishi\",\"color\":\"Blue\",\"type\":\"Sedan\"}";

    webTestClient.post().uri("/api/car/v1/echo")
    .contentType(MediaType.APPLICATION_JSON)
    .bodyValue(car).exchange().expectStatus().is2xxSuccessful();
  }

  @Test
  void testRandomCars() {
    webTestClient.get().uri("/api/car/v1/random-cars").exchange().expectStatus().is2xxSuccessful();
  }
  /*
  @Test
  void testRandomCars() {
    webTestClient.get().uri("/api/car/v1/random-cars").exchange().expectStatus().is2xxSuccessful().expectBodyList(Car.class).value(cars -> {
      assertNotNull(cars);
    });
  }

   */

  @Test
  void testCountCar() {
    webTestClient.get().uri("/api/car/v1/count").exchange().expectStatus().is2xxSuccessful().expectBody(String.class).value(v -> {
      assertThat(carRepository.count(), instanceOf(Long.class));
      assertTrue(v.contains(Long.toString(carRepository.count())));
    });
  }

  @Autowired
  @Qualifier("randomCarService")
  private CarService carService;

  @Test
  void testSaveCar() {
    var randomCar = carService.generateCar();

    for (int i = 0; i < 100; i++) {
      assertTimeout(Duration.ofSeconds(1),
          () -> webTestClient.post().uri("/api/car/v1").contentType(MediaType.APPLICATION_JSON)
          .bodyValue(randomCar).exchange().expectStatus().is2xxSuccessful());
    }
  }

  // @Test
  void testGetCar() {
    fail("Not yet implemented");
  }

  // @Test
  void testUpdateCar() {
    fail("Not yet implemented");
  }

  // @Test
  void testFindCarsByBrandAndColor() {
    fail("Not yet implemented");
  }

  // @Test
  void testFindCarsByPath() {
    fail("Not yet implemented");
  }

  @Test
  void testFindCarsByParam() {
    final int size = 5;

    for (var brand : CarService.BRANDS) {
      for (var color : CarService.COLORS) {
        webTestClient.get()
        .uri(uriBuilder -> uriBuilder.path("/api/car/v1/cars").queryParam("brand", brand)
            .queryParam("color", color).queryParam("page", 0).queryParam("size", size).build())
        .exchange().expectBodyList(Car.class).value(cars -> {
          assertNotNull(cars);
          assertTrue(cars.size() <= size);
        });

      }
    }
  }

  // @Test
  void testFindCarsReleasedAfter() {
    fail("Not yet implemented");
  }

}

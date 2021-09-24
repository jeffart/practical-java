/**
 *
 */
package com.course.praticaljava.entity;

/**
 * @author Intro
 *
 */
public class Engine {

  private String fuelType;

  private int horserPower;

  public Engine() {

  }


  public Engine(String fuelType, int horserPower) {
    super();
    this.fuelType = fuelType;
    this.horserPower = horserPower;
  }

  public String getFuelType() {
    return fuelType;
  }

  public int getHorserPower() {
    return horserPower;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public void setHorserPower(int horserPower) {
    this.horserPower = horserPower;
  }

  @Override
  public String toString() {
    return "Engine [fuelType=" + fuelType + ", horserPower=" + horserPower + "]";
  }



}

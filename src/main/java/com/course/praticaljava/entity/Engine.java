/**
 *
 */
package com.course.praticaljava.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Intro
 *
 */


@JsonIgnoreProperties(value = {"color","serialNumber"})
public class Engine {

  private String fuelType;

  private int horserPower;

  private String color = "Black";

  private String serialNumber ="SN00000001";

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

  public String getColor() {
    return color;
  }


  public void setColor(String color) {
    this.color = color;
  }


  public String getSerialNumber() {
    return serialNumber;
  }


  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }


  @Override
  public String toString() {
    return "Engine [fuelType=" + fuelType + ", horserPower=" + horserPower + "]";
  }



}

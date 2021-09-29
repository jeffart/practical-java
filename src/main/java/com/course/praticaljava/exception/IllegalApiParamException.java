package com.course.praticaljava.exception;

public class IllegalApiParamException extends RuntimeException {

  private static final long serialVersionUID = 7250886068063476412L;

  public IllegalApiParamException(String s) {
    super(s);
  }

}

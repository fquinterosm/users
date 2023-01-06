package com.bci.users.infraestructure.controller.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

public class ApiResponseMessagesList {

  @JsonProperty("mensaje")
  private List<String> message;

  public ApiResponseMessagesList(List<String> messages) {
    super();
    this.message = messages;
  }

  public ApiResponseMessagesList(int status, String message) {
    super();
    this.message = Arrays.asList(message);
  }


  public List<String> getMessage() {
    return message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }
}

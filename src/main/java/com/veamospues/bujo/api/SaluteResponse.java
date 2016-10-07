package com.veamospues.bujo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by alejandro on 7/10/16.
 */
public class SaluteResponse {
  @JsonProperty
  private Long id;

  @JsonProperty
  private String text;

  public SaluteResponse() {
  }

  public SaluteResponse(Long id, String text) {
    this.id = id;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

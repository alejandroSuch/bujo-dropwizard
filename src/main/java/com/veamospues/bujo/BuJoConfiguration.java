package com.veamospues.bujo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class BuJoConfiguration extends Configuration {
  @JsonProperty
  @NotEmpty
  private String template;

  @NotEmpty
  @JsonProperty
  private String defaultName;

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public String getDefaultName() {
    return defaultName;
  }

  public void setDefaultName(String defaultName) {
    this.defaultName = defaultName;
  }
}

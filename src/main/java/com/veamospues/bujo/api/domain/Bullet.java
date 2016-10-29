package com.veamospues.bujo.api.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

/**
 * Created by alejandro on 11/10/16.
 */
@Entity
@DynamicUpdate
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "bullet_type", discriminatorType = DiscriminatorType.STRING)
public class Bullet extends BaseEntity {
  public static final String TYPE_TASK = "TASK";
  public static final String TYPE_EVENT = "EVENT";
  public static final String TYPE_NOTE = "NOTE";
  public static final String TYPE_CASH_FLOW = "CASH_FLOW";
  public static final String TYPE_RECIPE = "RECIPE";

  @NotEmpty
  private String title;

  public String getTitle() {
    return title;
  }

  public Bullet setTitle(String title) {
    this.title = title;
    return this;
  }

  @Transient
  public String getType() {
    DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);

    return val == null ? null : val.value();
  }


}

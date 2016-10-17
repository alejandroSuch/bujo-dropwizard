package com.veamospues.bujo.api.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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

  @NotEmpty
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


}

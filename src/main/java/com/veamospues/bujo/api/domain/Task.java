package com.veamospues.bujo.api.domain;

import com.google.common.base.Preconditions;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by alejandro on 11/10/16.
 */
@Entity
@DiscriminatorValue(value = Bullet.TYPE_TASK)
public class Task extends Bullet {

  @Column(updatable = false, nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  Date doneDate;

  public Date getDoneDate() {
    return doneDate;
  }

  public void setDoneDate(Date doneDate) {
    Preconditions.checkState((doneDate == null && this.doneDate == null) || (doneDate != null && this.doneDate == null));
    Preconditions.checkState((doneDate == null && this.doneDate == null) || (doneDate == null && this.doneDate != null));

    this.doneDate = doneDate;
  }
}

package com.veamospues.bujo.api.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by alejandro on 15/10/16.
 */
@MappedSuperclass
public class BaseEntity {
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;

  @Column(updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;

  @Column(updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdated;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @PrePersist
  public void prePersist() {
    final Date now = new Date();

    if (this.dateCreated == null) {
      this.dateCreated = now;
    }

    this.lastUpdated = now;
  }
}

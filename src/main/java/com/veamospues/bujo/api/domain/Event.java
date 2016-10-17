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
@DiscriminatorValue(value = Bullet.TYPE_EVENT)
public class Event extends Bullet {

}

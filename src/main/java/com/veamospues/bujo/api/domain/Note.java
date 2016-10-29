package com.veamospues.bujo.api.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by alejandro on 11/10/16.
 */
@Entity
@DiscriminatorValue(value = Bullet.TYPE_NOTE)
public class Note extends Bullet {

}

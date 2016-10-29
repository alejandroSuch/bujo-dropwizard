package com.veamospues.bujo.api.dao;

import com.veamospues.bujo.api.dao.base.GenericDao;
import com.veamospues.bujo.api.domain.Event;

import java.util.UUID;

/**
 * Created by alejandro on 18/10/16.
 */
public interface EventDao extends GenericDao<Event, UUID> {
}

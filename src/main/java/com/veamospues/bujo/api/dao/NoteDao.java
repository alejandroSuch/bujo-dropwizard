package com.veamospues.bujo.api.dao;

import com.veamospues.bujo.api.dao.base.GenericDao;
import com.veamospues.bujo.api.domain.Note;

import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
public interface NoteDao extends GenericDao<Note, UUID> {
}

package com.udacity.jwdnd.course1.cloudstorage.Services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public int addNote(Note note) {
        return noteMapper.addNote(note);
    }

    public List<Note> getNotes(int userId) {
        return noteMapper.getNotesByUser(userId);
    }
}
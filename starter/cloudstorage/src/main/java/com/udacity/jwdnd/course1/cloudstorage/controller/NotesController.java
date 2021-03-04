package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {

    private NoteService noteService;
    private UserService userService;

    public NotesController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/insert-note")
    public String insertNote(NoteForm noteForm, Model model, Authentication authentication) {

        User user = userService.getUser(authentication.getName());

        Note note = new Note(noteForm.getNoteId(), noteForm.getNoteTitle(),noteForm.getNoteDescritption(),user.getUserid());
        noteService.addNote(note);

        model.addAttribute(s:"notes", noteService.getNotes(user.getUserid()));
        return "home";
    }
}

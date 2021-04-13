package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import com.udacity.jwdnd.course1.cloudstorage.Services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.Services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    private NoteService noteService;
    private UserService userService;

    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/insert-note")
    public String insertNote(NoteForm noteform, Model model, Authentication authentication) {

        User user = userService.getUser(authentication.getName());

        Note note = new Note(noteForm.getNoteId(), noteForm.getNoteTitle(),noteForm.getNoteDescritption(),user.getUserid());
        noteService.addNote(note);

        model.addAttribute("notes", noteService.getNotes(user.getUserid()));
        return "home";
    }
}

package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoteController {

    private NoteService noteService;
    private UserService userService;

    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/insert-note")
    public String insertNote(NoteForm noteForm, Model model, Authentication authentication) {

        User user = userService.getUser(authentication.getName());

        Note note = new Note(noteForm.getNoteId(), noteForm.getNoteTitle(),noteForm.getNoteDescritption(),user.getUserId());
        noteService.addNote(note);

        model.addAttribute("notes", noteService.getNotes(user.getUserId()));
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable(name = "id") String id, RedirectAttributes redirectAttributes) {






    }
}

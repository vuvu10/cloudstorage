package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.Model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.Service.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.Service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private  NoteService noteService;
    private Credential credential;
    private FileService fileService;
    private EncryptionService encryptionService;


    public HomeController(NoteService noteService, Credential credential, Authentication authentication, Model model) {
        this.noteService = noteService;
        this.credential = credential;
    }



    @GetMapping
    public String homeView(NoteForm noteForm, File file ) {




        return "home";
    }
}

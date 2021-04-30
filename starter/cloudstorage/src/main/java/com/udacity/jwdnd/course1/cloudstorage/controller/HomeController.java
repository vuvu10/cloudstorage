package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private  final NoteService noteService;
    private final UserService UserService;
    private final FileService fileService;
    private final EncryptionService encryptionService;


    public HomeController(NoteService noteService, UserService userService, FileService fileService, EncryptionService encryptionService) {
        this.noteService = noteService;
        this.fileService = fileService;
        this.encryptionService = encryptionService;
        this.UserService = userService;
    }



    @GetMapping
    public String homeView(Model model, Authentication authentication) {
        User user = UserService.getUser(authentication.getName());
        model.addAttribute("notes", noteService.getNotes(user.getUserId()));
        model.addAttribute("file", fileService.getAllUserFiles(user.getUserId()));
        model.addAttribute("EncryptionService", encryptionService);
        model.addAttribute("FileService", fileService );
        model.addAttribute("UserService", UserService );

        return "home";
    }
}

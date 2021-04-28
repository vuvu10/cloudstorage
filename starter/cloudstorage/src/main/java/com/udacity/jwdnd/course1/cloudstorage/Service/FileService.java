package com.udacity.jwdnd.course1.cloudstorage.Service;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

//import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;
    private UserService userService;

    public FileService(FileMapper fileMapper, UserService userService) {
        this.fileMapper = fileMapper;
        this.userService = userService;
    }



    public List<File> getAllUserFiles(int userId) {

        return fileMapper.getFiles(userId);
    }

    public File getFile(Integer fileId) {
        return fileMapper.getFileById(fileId);
    }

    public  boolean



}

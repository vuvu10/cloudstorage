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

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public List<File> getAllUserFiles(int userId) {
        return fileMapper.getFiles(userId);
    }

    public void createFile(File file) throws FileisInUseException {
        if (this.fileMapper.getFileByName(file.getUserid(), file.getFilename()).isEmpty()) {
            this.fileMapper.insert(file);
        } else {
            throw new FileisInUseException();
        }


    }

    public void deleteFile(int FileId) {
        this.fileMapper.deleteFile(FileId);
    }

    public File getFileById(int FileId) {
        return this.fileMapper.getFileById(FileId);
    }



}

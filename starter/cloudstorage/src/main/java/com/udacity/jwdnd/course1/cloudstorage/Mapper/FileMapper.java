package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("select * from files where userid = #{userid}")
    List<File> getFiles(int userId);

    @Select("select * from files where filename = #{filename} and userid = #{userid}")
    File getFileByName(String filename);

    @Delete("delete from files where fileid = #{fileId}")
    void deleteFile(int fileId);

    @Insert("insert into files (filename, contenttype, filesize, userid, filedata) VALUES(#{filename}, #{contenttype}, #{filesize}, #{userid}, #{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(File file);

    @Select("select * from where fileid = #{fileId}")
    File getFileById(int fielId);
}

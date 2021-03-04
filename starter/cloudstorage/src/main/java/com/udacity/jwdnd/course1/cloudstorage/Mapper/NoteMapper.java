package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public class NoteMapper {

    @Select("SELECT * FROM N0TES WHERE userid = #{userId}")
    List<Note> getNotesByUser(int userId);

    @Insert("INSERT INTO NOTES(notetile, notedescription, userid) " +
            "values(#{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int addNote(Note note);
}

package com.udacity.jwdnd.course1.cloudstorage.Model;



public class Note {
    private Integer noteid;
    private String notetile;
    private String noteDescription;
    private int userId;

    public Note(int noteid, String notetile, String noteDescription, int userId) {
        this.noteid = noteid;
        this.notetile = notetile;
        this.noteDescription = noteDescription;
        this.userId = userId;
    }

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public String getNotetile() {
        return notetile;
    }

    public void setNotetile(String notetile) {
        this.notetile = notetile;
    }

    public String getNoteDescription() { return noteDescription; }

    public void setNoteDescription(String noteDescription) { this.noteDescription = noteDescription; }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}

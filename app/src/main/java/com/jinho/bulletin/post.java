package com.jinho.bulletin;

/**
 * Created by Yoon on 2017-11-25.
 */

public class post {
    private int ID;
    private int writerID;
    private String title;
    private String dateTime;
    private boolean IsFinish;
    private int commentID;
    private int contentID;

    public void delete (){
        //delete this post
    }
    public void change () {
        // change this post
    }
    public void report () {
        //report this writer to manager
    }

    //Constructors
    public post() {
    }
    public post(int ID, int writerID, String title, String dateTime, boolean isFinish, int commentID, int contentID) {
        this.ID = ID;
        this.writerID = writerID;
        this.title = title;
        this.dateTime = dateTime;
        IsFinish = isFinish;
        this.commentID = commentID;
        this.contentID = contentID;
    }

    //Getter&Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWriterID() {
        return writerID;
    }

    public void setWriterID(int writerID) {
        this.writerID = writerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isFinish() {
        return IsFinish;
    }

    public void setFinish(boolean finish) {
        IsFinish = finish;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getcontentID() {
        return contentID;
    }

    public void setcontentID(int contentID) {
        this.contentID = contentID;
    }
}

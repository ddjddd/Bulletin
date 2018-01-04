package com.jinho.bulletin.Message;

/**
 * Created by ddjdd on 2017-12-26.
 */

public class Message {
    private String messageKey;
    private boolean IsFinish;
    private String senderID, receiverID;
    private String title, dateTime, memo;

    public void delete (){
        //delete this post
    }
    public void change () {
        // change this post
    }
    public void makeFinish(){
        //make post's condition finished
    }

    //constructor
    public Message() {      }

    public Message(String messageKey, boolean IsFinish, String senderID, String receiverID, String title, String dateTime, String memo) {
        this.messageKey = messageKey;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.IsFinish = IsFinish;
        this.title = title;
        this.dateTime = dateTime;
        this.memo = memo;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }


    public boolean isFinish() {
        return IsFinish;
    }
    public void setFinish(boolean finish) {
        IsFinish = finish;
    }



    public String getSenderID() {
        return senderID;
    }
    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }
    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
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

    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

}


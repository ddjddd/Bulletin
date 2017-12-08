package com.jinho.bulletin;

/**
 * Created by Yoon on 2017-11-26.
 */

public class SecondhandPost {
    //private int IDSecond;
    private String writerID;
    //private String commentID;
    private boolean IsFinish;
    private String dateTime, title, price, memo, category1, category2, condition, location;

    public void delete (){
        //delete this post
    }
    public void change () {
        // change this post
    }
    public void report () {
        //report this writer to manager
    }
    public void makeFinish(){
        //make post's condition finished
    }

    //constructor
    public SecondhandPost() {
    }
    public SecondhandPost( String writerID, boolean isFinish, String dateTime, String title, String price, String memo, String category1, String category2, String condition, String location) {
        //this.IDSecond = IDSecond;
        this.writerID = writerID;
        IsFinish = isFinish;
        this.dateTime = dateTime;
        this.title = title;
        this.price = price;
        this.memo = memo;
        this.category1 = category1;
        this.category2 = category2;
        this.condition = condition;
        this.location = location;
    }


    public String getWriterID() {
        return writerID;
    }

    public void setWriterID(String writerID) {
        this.writerID = writerID;
    }

    public boolean isFinish() {
        return IsFinish;
    }

    public void setFinish(boolean finish) {
        IsFinish = finish;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}


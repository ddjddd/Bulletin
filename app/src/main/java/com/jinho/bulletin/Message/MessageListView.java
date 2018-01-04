package com.jinho.bulletin.Message;
/**
 * Created by ddjdd on 2018-01-04.
 */

public class MessageListView {
    private String messageKey;
    private boolean IsFinish;
    private String senderIDStr, receiverIDStr;
    private String titleStr, dateStr;

    public void setTitle(String title) {
        titleStr = title;
    }
    public String getTitle() { return this.titleStr; }

    public void setDate(String date) {dateStr = date; }
    public String getDate() { return this.dateStr; }

    public void setSenderID(String senderID) {senderIDStr = senderID; }
    public String getSenderID() { return this.senderIDStr; }

    public void setReceiverID(String receiverID) {senderIDStr = receiverID; }
    public String getReceiverID() { return this.receiverIDStr; }
}

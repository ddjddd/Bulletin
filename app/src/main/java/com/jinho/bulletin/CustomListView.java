package com.jinho.bulletin;

import android.graphics.drawable.Drawable;

/**
 *  커스텀 리스트뷰 클래스
 */

public class CustomListView {
    //    private Drawable iconDrawable ;
    private String titleStr;
    private String memoStr;
    private String dateStr;
    private String writerStr;

    /*
        public void setIcon(Drawable icon) {
            iconDrawable = icon;
        }*/
    public void setTitle(String title) {
        titleStr = title;
    }

    public void setMemo(String memo) { memoStr = memo; }

    public void setDate(String date) {dateStr = date; }

    public void setWriter(String writer) {writerStr = writer; }

    /*
        public Drawable getIcon() {
            return this.iconDrawable ;
        }*/
    public String getTitle() {
        return this.titleStr;
    }

    public String getMemo() {
        return this.memoStr;
    }

    public String getDate() { return this.dateStr; }

    public String getWriter() { return this.writerStr; }
}
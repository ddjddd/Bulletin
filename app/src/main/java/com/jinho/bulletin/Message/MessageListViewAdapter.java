package com.jinho.bulletin.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jinho.bulletin.R;

import java.util.ArrayList;

/**
 * Created by ddjdd on 2018-01-04.
 */


public class MessageListViewAdapter extends BaseAdapter {
    private ArrayList<Message> messageItemList = new ArrayList<>();

    // 빈 생성자
    public MessageListViewAdapter() { }

    // 만든 리스트의 개체수
    @Override
    public int getCount() {
        return messageItemList.size();
    }

    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.messagebox_listview, parent, false);
        }

        // xml 링크
        TextView titleTextView = (TextView) convertView.findViewById(R.id.messageTitle);
        TextView senderIDTextView = (TextView) convertView.findViewById(R.id.messageSenderID);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.messageDate);

        Message messageItem = messageItemList.get(pos);

        titleTextView.setText(messageItem.getTitle());
        senderIDTextView.setText(messageItem.getMemo());
        dateTextView.setText(messageItem.getDateTime());

        return convertView;
    }

    //
    @Override
    public long getItemId(int position) {
        return position ;
    }

    //
    @Override
    public Object getItem(int position) {
        return messageItemList.get(position) ;
    }

    // 리스트에 새로운 글 추가
    public void addItem(Message item) {
        messageItemList.add(item);
    }
}
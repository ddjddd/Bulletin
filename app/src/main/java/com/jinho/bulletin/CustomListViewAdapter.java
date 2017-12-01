package com.jinho.bulletin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 커스텀 리스트 뷰 어댑터 클래스
 */

public class CustomListViewAdapter extends BaseAdapter {
    private ArrayList<SecondhandPost> shPostItemList = new ArrayList<>();

    // 빈 생성자
    public CustomListViewAdapter() { }

    // 만든 리스트의 개체수
    @Override
    public int getCount() {
        return shPostItemList.size();
    }

    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sh_bulletin_listview, parent, false);
        }

        // xml 링크
        TextView titleTextView = (TextView) convertView.findViewById(R.id.postTitle);
        TextView memoTextView = (TextView) convertView.findViewById(R.id.postMemo);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.postDate);
     //   TextView writerTextView= (TextView) convertView.findViewById(R.id.postWriter);

        //
        SecondhandPost ShPostItem = shPostItemList.get(pos);

        titleTextView.setText(ShPostItem.getTitle());
        memoTextView.setText(ShPostItem.getMemo());
        dateTextView.setText(ShPostItem.getDateTime());
   //     writerTextView.setText(SecondhandPostItem.getWriterID());

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
        return shPostItemList.get(position) ;
    }

    // 리스트에 새로운 글 추가
     public void addItem(SecondhandPost item) {
         shPostItemList.add(item);
    }
}
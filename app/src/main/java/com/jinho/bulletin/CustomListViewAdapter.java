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
    private ArrayList<CustomListView> CustomListViewItemList = new ArrayList<CustomListView>();

    // 빈 생성자
    public CustomListViewAdapter() { }

    // 만든 리스트의 개체수
    @Override
    public int getCount() {
        return CustomListViewItemList.size();
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
        TextView writerTextView= (TextView) convertView.findViewById(R.id.postWriter);

        //
        CustomListView CustomListViewItem = CustomListViewItemList.get(position);

        titleTextView.setText(CustomListViewItem.getTitle());
        memoTextView.setText(CustomListViewItem.getMemo());
        dateTextView.setText(CustomListViewItem.getDate());
        writerTextView.setText(CustomListViewItem.getWriter());

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
        return CustomListViewItemList.get(position) ;
    }

    // 리스트에 새로운 글 추가
    public void addItem(String title, String memo, String date, String writer) {
        CustomListView item = new CustomListView();

        // item.setIcon(icon);
        item.setTitle(title);
        item.setMemo(memo);
        item.setDate(date);
        item.setWriter(writer);

        CustomListViewItemList.add(item);
    }
}
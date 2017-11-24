package com.jinho.bulletin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ddjdd on 2017-11-25.
 */

public class CustomListViewAdapter extends BaseAdapter {
    private ArrayList<CustomListView> CustomListViewItemList = new ArrayList<CustomListView>();

    public CustomListViewAdapter() {

    }

    @Override
    public int getCount() {
        return CustomListViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sh_bulletin_listview, parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);

        CustomListView CustomListViewItem = CustomListViewItemList.get(position);

        titleTextView.setText(CustomListViewItem.getTitle());
        descTextView.setText(CustomListViewItem.getDesc());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return CustomListViewItemList.get(position) ;
    }

    //   public void addItem(Drawable icon, String title, String desc) {
    public void addItem(String title, String desc) {
        CustomListView item = new CustomListView();

        // item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        CustomListViewItemList.add(item);
    }
}
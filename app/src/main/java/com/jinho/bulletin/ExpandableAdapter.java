package com.jinho.bulletin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yoon on 2017-12-18.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private ArrayList<String> mParentList;
   // private ArrayList<ChildListData> mChildList;
   // private ChildListViewHolder mChildListViewHolder;
   // private HashMap<String, ArrayList<ChildListData>> mChildHashMap;
    // CustomExpandableListViewAdapter 생성자
    public ExpandableAdapter(Context context, ArrayList<String> parentList, HashMap<String, ArrayList<String>> childHashMap){
        this.mContext = context;
        this.mParentList = parentList;
        //this.mChildHashMap = childHashMap;
    }

    /* ParentListView에 대한 method */
    @Override
    public String getGroup(int groupPosition) { // ParentList의 position을 받아 해당 TextView에 반영될 String을 반환
        return mParentList.get(groupPosition);
    }

    @Override
    public int getGroupCount() { // ParentList의 원소 개수를 반환
        return mParentList.size();
    }

    @Override
    public long getGroupId(int groupPosition) { // ParentList의 position을 받아 long값으로 반환
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) { // ParentList의 View
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return convertView;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    /* 여기서부터 ChildListView에 대한 method*/
    @Override
    public String getChild(int groupPosition, int childPosition) { // groupPostion과 childPosition을 통해 childList의 원소를 얻어옴
        return null;

    }

    @Override
    public int getChildrenCount(int groupPosition) { // ChildList의 크기를 int 형으로 반환
        return 0;

    }


    @Override
    public boolean hasStableIds() { return true; } // stable ID인지 boolean 값으로 반환

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; } // 선택여부를 boolean 값으로 반환


}

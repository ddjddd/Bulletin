package com.jinho.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//secondhand bulletin에서 글 객체를 클릭시 글을 보여주는 activity
public class secondhandShowPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondhand_show_post);
    }
}

package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Post 보기
 */

public class SecondhandPostActivity  extends AppCompatActivity {
    private Intent intent;
    private TextView postTitle, postCategory1, postCategory2, postPrice, postCondition, postLocation, postMemo;
    private Button returnBulletin;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondhand_post);

        intent = getIntent();

        // xml 링크
        postTitle = (TextView) findViewById(R.id.postTitle);
        postCategory1 = (TextView) findViewById(R.id.postCategory1);
        postCategory2 = (TextView) findViewById(R.id.postCategory2);
        postPrice = (TextView) findViewById(R.id.postPrice);
        postCondition= (TextView) findViewById(R.id.postCondition);
        postLocation = (TextView) findViewById(R.id.postLocation);
        postMemo = (TextView) findViewById(R.id.postMemo);

        // intent의 값을 출력
        postTitle.setText(intent.getStringExtra("title"));
        postCategory1.setText(intent.getStringExtra("category1"));
        postCategory2.setText(intent.getStringExtra("category2"));
        postPrice.setText(intent.getStringExtra("price"));
        postCondition.setText(intent.getStringExtra("condition"));
        postLocation.setText(intent.getStringExtra("location"));
        postMemo.setText(intent.getStringExtra("memo"));
    }
}
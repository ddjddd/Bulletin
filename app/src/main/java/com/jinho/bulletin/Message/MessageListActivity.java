package com.jinho.bulletin.Message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jinho.bulletin.R;

/**
 * Created by ddjdd on 2017-12-26.
 */

public class MessageListActivity extends AppCompatActivity {

    private Button mb_receive, mb_new, mb_send, mb_write;
    private ListView mb_messageList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    MessageListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        adapter =  new MessageListViewAdapter();
       // mb_receive = (Button) findViewById(R.id.mb_receive);
      //  mb_new = (Button) findViewById(R.id.mb_new);
      //  mb_send = (Button) findViewById(R.id.mb_send);
       // mb_write = (Button) findViewById(R.id.mb_write);

     /*   mb_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 받은 메세지 전부 정렬
            }
        });
       mb_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로온 메세지만 정렬
            }
        });
        mb_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 보낸 메세지만 정렬
            }
        });*/

        FloatingActionButton mb_write = (FloatingActionButton) findViewById(R.id.mb_write);
        mb_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MessageWritingActivity.class);
                startActivity(intent);
            }
        });
/*
        mb_messageList = (ListView) findViewById(R.id.mb_messageList);

        mb_messageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Message currentMessage = (Message)adapter.getItem(position);

             //   Intent intent = new Intent(getApplicationContext(), SecondhandPostActivity.class);
              //  intent.putExtra("senderID", currentMessage.getSenderID());

              //  startActivity(intent);
            }

            public void onClick(View v) { }
        });
        showMessageList();*/
    }

    private void showMessageList() {
        mb_messageList.setAdapter(adapter);

        databaseReference.child("Message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }
}

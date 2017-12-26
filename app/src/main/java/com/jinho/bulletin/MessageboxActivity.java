package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ddjdd on 2017-12-26.
 */

public class MessageboxActivity extends AppCompatActivity {

    private Button mb_receive, mb_new, mb_send;
    private ListView mb_messageList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messagebox);

        adapter =  new CustomListViewAdapter() ;
        mb_receive = (Button) findViewById(R.id.mb_receive);
        mb_new = (Button) findViewById(R.id.mb_new);
        mb_send = (Button) findViewById(R.id.mb_send);

        mb_receive.setOnClickListener(new View.OnClickListener() {
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
        });

        mb_messageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Message currentMessage = (Message)adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), SecondhandPostActivity.class);
                intent.putExtra("senderID", currentMessage.getSenderID());

                startActivity(intent);
            }

            public void onClick(View v) { }
        });

        showMessageList();
    }

    private void showMessageList() {
        mb_messageList.setAdapter(adapter);

        databaseReference.child("Message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SecondhandPost newPost = dataSnapshot.getValue(SecondhandPost.class);
                adapter.addItem(newPost);
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

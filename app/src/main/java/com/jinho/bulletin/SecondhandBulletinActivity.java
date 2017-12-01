package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;

/*
  Secondhand - products bulletin board Activity
*/
public class SecondhandBulletinActivity extends AppCompatActivity {

    private Button sh_bulletin_write;
    private ListView sh_postList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondhand_bulletin);

        sh_bulletin_write = (Button) findViewById(R.id.sh_bulletin_next);
        sh_postList = (ListView) findViewById(R.id.sh_articleList);

        sh_bulletin_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // writing activity
                Intent intent = new Intent(getApplicationContext(), SecondhandWritingActivity.class);
                startActivity(intent);
            }
        });
        showChatList();
    }

    private void showChatList() {
        final CustomListViewAdapter adapter =  new CustomListViewAdapter() ;

        adapter.addItem("<팜> 라면포트", "$5000~", "17. 12. 1", "ddjddd");      // example

        sh_postList.setAdapter(adapter);

        databaseReference.child("Article").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                post newPost = dataSnapshot.getValue(post.class);
             //   adapter.addItem(newPost.getTitle(), newPost.getMemo(), newPost.getDateTime(),Integer.toString(newPost.getWriterID()));
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

package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

 //   private SecondhandPost newPost;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondhand_bulletin);

        adapter =  new CustomListViewAdapter() ;
        sh_bulletin_write = (Button) findViewById(R.id.sh_bulletin_next);
        sh_postList = (ListView) findViewById(R.id.sh_articleList);

        sh_bulletin_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // writing activity로 전환
                Intent intent = new Intent(getApplicationContext(), SecondhandWritingActivity.class);
                startActivity(intent);
            }
        });

        sh_postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SecondhandPost newPost = (SecondhandPost)adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), SecondhandPostActivity.class);
                // putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값
                //intent.putExtra("IDSecond", newPost.getIDSecond());
                intent.putExtra("writerID", newPost.getWriterID());
                //intent.putExtra("commentID", newPost.getCommentID());

                intent.putExtra("IsFinished", newPost.isFinish());

                intent.putExtra("title", newPost.getTitle());
                intent.putExtra("dateTime", newPost.getDateTime());
                intent.putExtra("price", newPost.getPrice());
                intent.putExtra("memo", newPost.getMemo());
                intent.putExtra("category1", newPost.getCategory1());
                intent.putExtra("category2", newPost.getCategory2());
                intent.putExtra("condition", newPost.getCondition());
                intent.putExtra("location", newPost.getLocation());

                startActivity(intent);
            }

            public void onClick(View v) { }
        });

        showChatList();
    }

    private void showChatList() {
        sh_postList.setAdapter(adapter);

        // sample
        SecondhandPost example = new SecondhandPost("1", true,
                "2017-12-02-00-00", "<팜>역전우동", "$200", "개비싸게 산다", "식품", "점심", "최상", "율전성당 앞");

        adapter.addItem(example);
        databaseReference.child("SecondhandPost").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SecondhandPost newPost = dataSnapshot.getValue(SecondhandPost.class);
             //   adapter.addItem(newPost.getTitle(), newPost.getTitle(), newPost.getDateTime(),Integer.toString(newPost.getWriterID()));
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

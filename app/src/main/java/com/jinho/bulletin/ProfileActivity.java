package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    private Button profile_next;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    // 부터


    private Button Misson, Next, Secondhand, messagebox;
    private EditText Search;

    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button btnNewActivity = (Button) findViewById(R.id.secondhandwriting);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondhandWritingActivity.class); //글쓰는창으로 이동. 이 액티비티 맞는지
                startActivity(intent);
            }
         });

        //editSearch = (EditText) findViewById(R.id.editSearch);
        //listView = (ListView) findViewById(R.id.listview);

        // profile.xml 파일의 각각의 버튼마다 android:id="@+id/pf_next" 부분의 pf_next 같은 id를 직접 지정해 주어야 함.....
        // 이하 xx
        profile_next = (Button) findViewById(R.id.secondhand);
        profile_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondhandBulletinActivity.class);
                startActivity(intent);
            }

        });
        // xx xx


        ////
        messagebox = (Button) findViewById(R.id.messagebox);
        messagebox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MessageListActivity.class);
                startActivity(intent);
            }

        });

    }

}

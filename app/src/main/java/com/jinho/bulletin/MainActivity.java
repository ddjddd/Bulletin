package com.jinho.bulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * 메인 로그인 화면
 */

public class MainActivity extends AppCompatActivity {
    private EditText editUserID, editUserPW;
    private Button user_signIn, user_signUp;

    // 입력된 ID, PW
    private String userID, userPW;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 링크
        editUserID = (EditText) findViewById(R.id.editUserID);
        editUserPW = (EditText) findViewById(R.id.editUserPW);
        user_signIn = (Button) findViewById(R.id.user_signIn);
        user_signUp = (Button) findViewById(R.id.user_signUp);

        // 로그인
        user_signIn= (Button) findViewById(R.id.user_signIn);
        user_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 프로필 페이지로 이동
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        // 회원가입
        user_signUp= (Button) findViewById(R.id.user_signUp);
        user_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 페이지로 이동
            }
        });

    }
}
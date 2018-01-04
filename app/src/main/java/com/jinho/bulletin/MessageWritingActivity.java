package com.jinho.bulletin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ddjdd on 2018-01-04.
 */

public class MessageWritingActivity extends AppCompatActivity {
    private Button writingFinish;
    private EditText editTitle, editReceiver, editMemo;

    private String title, receiver, memo;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_writing);

        writingFinish = (Button) findViewById(R.id.writingFinish);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editReceiver = (EditText) findViewById(R.id.editReceiver);
        editMemo = (EditText) findViewById(R.id.editMemo);

        writingFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = editTitle.getText().toString();
                receiver = editReceiver.getText().toString();
                memo = editMemo.getText().toString();


                if(!title.equals("") && !receiver.equals("") && !memo.equals("")){
                    //UserID 가져오기
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user != null){
                        //글id는 push를 사용하여 만들 수 있다
                        String messageKey = databaseReference.push().getKey();
                        //임시 userID
                        String userID = "11111111";
                        //String userID = user.getUid();
                        //현재 시간 가져오기
                        Date date = new Date();
                        SimpleDateFormat full_sdf = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
                        String dateTime = full_sdf.format(date).toString();
                        Message newMessage = new Message(messageKey, false, userID, receiver, title, dateTime, memo);
                        databaseReference.child("message").push().setValue(newMessage);
                        //프로필로 넘어가기
                        Toast.makeText(MessageWritingActivity.this, "입력완료",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(MessageWritingActivity.this, "로그인을 해주세요",Toast.LENGTH_SHORT).show();
                        //또는 뒤로가기
                        finish();
                    }
                }

                else{
                    Toast.makeText(MessageWritingActivity.this, "다 입력해주세요",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

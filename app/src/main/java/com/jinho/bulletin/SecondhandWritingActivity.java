package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
  Secondhand - products bulletin board Activity
*/
public class SecondhandWritingActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adspin1;
    ArrayAdapter<CharSequence> adspin2;

    private Button buttonFinish;
    private EditText editTitle, editPrice, editMemo;
    private Spinner spinCategory1, spinCategory2, spinCondition, spinLocation;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private String title, price, memo, category1, category2, condition, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondhand_writing);

        //sh_writing_next = (Button) findViewById(R.id.sh_writing_next);

        buttonFinish = (Button) findViewById(R.id.buttonFinish);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editPrice = (EditText) findViewById(R.id.editPrice);
        editMemo = (EditText) findViewById(R.id.editMemo);
        spinCategory1 = (Spinner) findViewById(R.id.spinCategory1);
        spinCategory2 = (Spinner) findViewById(R.id.spinCategory2);
        spinCondition = (Spinner) findViewById(R.id.spinCondition);
        spinLocation = (Spinner) findViewById(R.id.spinLocation);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.category1,android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCategory1.setAdapter(adspin1);
        spinCategory1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(adspin1.getItem(position).equals("가구")){
                    category1 = "가구";
                    adspin2 = ArrayAdapter.createFromResource(SecondhandWritingActivity.this, R.array.furniture, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinCategory2.setAdapter(adspin2);
                    spinCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            category2 = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            category2 = "";
                        }
                    });
                }
                else if(adspin1.getItem(position).equals("전자기기")){
                    category1 = "전자기기";
                    adspin2 = ArrayAdapter.createFromResource(SecondhandWritingActivity.this, R.array.electronicEq, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinCategory2.setAdapter(adspin2);
                    spinCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            category2 = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            category2 = "";
                        }
                    });
                }
                else if(adspin1.getItem(position).equals("책")){
                    category1 = "책";
                    adspin2 = ArrayAdapter.createFromResource(SecondhandWritingActivity.this, R.array.book, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinCategory2.setAdapter(adspin2);
                    spinCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            category2 = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            category2 = "";
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    category1 = "";
            }
        });

        spinCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                condition = spinCondition.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                condition = "";
            }
        });

        spinLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location = spinLocation.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                location = "";
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    title = editTitle.getText().toString();
                    price = editPrice.getText().toString();
                    memo = editMemo.getText().toString();

                    if(!title.equals("") && !category1.equals("") && !category2.equals("") && !price.equals("") && !condition.equals("") && !location.equals("") && !memo.equals("")){
                        //UserID 만들기
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        //잠시 테스트용소스
                        //글id는 push를 사용하여 만들 수 있다
                        String postKey = databaseReference.push().getKey();
                        //객체 만들기
                        String userID = "11111111";
                        //현재 시간 가져오기
                        Date date = new Date();
                        SimpleDateFormat full_sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
                        String dateTime = full_sdf.format(date).toString();
                        //post객체 생성
                        SecondhandPost posting = new SecondhandPost(userID, false, dateTime, title, price, memo, category1,category2, condition, location);
                        //객체 DB넘기기
                        databaseReference.child("secondhandPost").setValue(posting);
                        //프로필로 넘어가기
                        Toast.makeText(SecondhandWritingActivity.this, "입력완료",Toast.LENGTH_SHORT).show();
                        finish();
                        /*
                        if(user != null){
                            //글id는 push를 사용하여 만들 수 있다
                            String postKey = databaseReference.push().getKey();
                            //객체 만들기
                            String userID = user.getUid();
                            //현재 시간 가져오기
                            Date date = new Date();
                            SimpleDateFormat full_sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
                            String dateTime = full_sdf.format(date).toString();
                            //post객체 생성
                            SecondhandPost posting = new SecondhandPost(userID, false, dateTime, title, price, memo, category1,category2, condition, location);
                            //객체 DB넘기기
                            databaseReference.child("secondhandPost").setValue(posting);
                            //프로필로 넘어가기
                            finish();
                        }
                        else{
                            Toast.makeText(SecondhandWritingActivity.this, "로그인을 해주세요",Toast.LENGTH_SHORT).show();
                            //또는 뒤로가기
                            finish();
                        }
                        */
                    }
                    else{
                        Toast.makeText(SecondhandWritingActivity.this, "다 입력해주세요",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
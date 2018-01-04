package com.jinho.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * 메인 로그인 화면
 */

public class MainActivity extends AppCompatActivity {

    private EditText editUserID, editUserPW;
    private Button user_signIn, user_signUp;
    private FirebaseAuth mAuth;

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
        mAuth = FirebaseAuth.getInstance();

        // 로그인
        user_signIn = (Button) findViewById(R.id.user_signIn);
        user_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn_User(editUserID.getText().toString(), editUserPW.getText().toString());
            }
        });

        // 회원가입
        user_signUp = (Button) findViewById(R.id.user_signUp);
        user_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 회원가입 페이지로 이동
                Intent intent = new Intent(getApplication(), makeMembership.class);
                startActivity(intent);
            }
        });

    }

    private void signIn_User(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // 프로필 페이지로 이동
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            FirebaseAuth.getInstance().signOut();
        }
        else{
            Toast.makeText(MainActivity.this, "no login",Toast.LENGTH_LONG).show();
        }
    }
}
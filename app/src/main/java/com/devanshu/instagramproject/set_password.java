package com.devanshu.instagramproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class set_password extends AppCompatActivity {
    private EditText box;
    private Button next;
    private TextView login;

    private DatabaseReference mref;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        box = findViewById(R.id.passbox);
        next = findViewById(R.id.passnext);
        login = findViewById(R.id.passlogin);

        mref = FirebaseDatabase.getInstance().getReference();
        mauth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(set_password.this, start_activity.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password =  box.getText().toString();

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(set_password.this, "Password can't be empty!", Toast.LENGTH_SHORT).show();
                } else if(password.length()< 6) {
                    Toast.makeText(set_password.this, "Password too Short!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String emailid = getIntent().getStringExtra("email");
                    String fullname = getIntent().getStringExtra("name");
                    String username = getIntent().getStringExtra("usname");

                    createAccount(username,fullname,emailid,password);
                }
            }
        });
    }

    private void createAccount(String username, String fullname, String emailid, String password) {
        mauth.createUserWithEmailAndPassword(emailid,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                HashMap<String,Object> map = new HashMap<>();
                map.put("name",fullname);
                map.put("email",emailid);
                map.put("username",username);
                map.put("id",mauth.getCurrentUser().getUid());

                mref.child("users").child(mauth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(set_password.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(set_password.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(set_password.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
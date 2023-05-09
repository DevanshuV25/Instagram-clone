package com.devanshu.instagramproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class new_username extends AppCompatActivity {

    private EditText box;
    private Button next;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_username);

        box = findViewById(R.id.unbox);
        next = findViewById(R.id.unnext);
        login = findViewById(R.id.unlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(new_username.this, start_activity.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =  box.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(new_username.this, "Username can't be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    String emailid = getIntent().getStringExtra("email");
                    String fname = getIntent().getStringExtra("name");
                    Intent b = new Intent(new_username.this, set_password.class);
                    b.putExtra("email",emailid);
                    b.putExtra("name",fname);
                    b.putExtra("usname",username);
                    startActivity(b);
                }
            }
        });
    }
}
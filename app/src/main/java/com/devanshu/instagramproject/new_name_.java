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

public class new_name_ extends AppCompatActivity {

    private TextView txt1,txt2;
    private EditText box;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_name);

        txt1 = findViewById(R.id.nametxt);
        txt2 = findViewById(R.id.namelogin);
        box = findViewById(R.id.namebox);
        next = findViewById(R.id.namenext);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(new_name_.this, start_activity.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname =  box.getText().toString();

                if (TextUtils.isEmpty(fullname)) {
                    Toast.makeText(new_name_.this, "Name can't be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    String emailid = getIntent().getStringExtra("email");
                    Intent b = new Intent(new_name_.this, new_username.class);
                    b.putExtra("name",fullname);
                    b.putExtra("email",emailid);
                    startActivity(b);
                }
            }
        });

    }
}
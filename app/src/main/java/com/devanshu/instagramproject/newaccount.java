package com.devanshu.instagramproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newaccount extends AppCompatActivity {

    private TextView txt1;

    private TextView txt2;

    private EditText emailbox;

    private Button emailnext;

    private TextView emaillogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);

        txt1 = findViewById(R.id.email1);
        txt2 = findViewById(R.id.email2);
        emailbox = findViewById(R.id.emailbox);
        emailnext = findViewById(R.id.emailnext);
        emaillogin = findViewById(R.id.emailtxt);

        emaillogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(newaccount.this, start_activity.class));
            }
        });

        emailnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailid = emailbox.getText().toString();

                if (TextUtils.isEmpty(mailid)) {
                    Toast.makeText(newaccount.this, "Email can't be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent a = new Intent(newaccount.this, new_name_.class);
                    a.putExtra("email",mailid);
                    startActivity(a);
                }
            }
        });

    }
}

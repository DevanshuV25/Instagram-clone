package com.devanshu.instagramproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class start_activity extends AppCompatActivity {

    private ImageView logo;
    private Button signup;
    private ImageView text;
    private Button login;
    private LinearLayout layout;

    private RelativeLayout mlayout;

    private ImageView mylogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logo = findViewById(R.id.splashlogo);
        signup = findViewById(R.id.signupbutton);
        text = findViewById(R.id.textinsta);
        login = findViewById(R.id.loginbutton);
        layout = findViewById(R.id.loginlayout);
        mlayout = findViewById(R.id.mainlayout);
        mylogo =findViewById(R.id.mylogo);




        mlayout.animate().alpha(0f).setDuration(10);

        TranslateAnimation splash = new TranslateAnimation(0,0,0,0);
        splash.setDuration(1000);
        splash.setFillAfter(false);
        splash.setAnimationListener(new animationListerner());

        logo.setAnimation(splash);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(start_activity.this,newaccount.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    private class animationListerner implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            logo.clearAnimation();
            logo.setVisibility(View.INVISIBLE);
            mlayout.animate().alpha(1f).setDuration(1000);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
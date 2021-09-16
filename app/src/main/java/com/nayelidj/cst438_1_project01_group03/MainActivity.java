package com.nayelidj.cst438_1_project01_group03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mcreateAcctBtn;
    private Button mLoginBtn;
    Animation rotateAnimation;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.jobHuntImageView);
        rotateAnimation();
        mcreateAcctBtn = findViewById(R.id.createAcctbtn);
        mLoginBtn = findViewById(R.id.loginbtn);

        mcreateAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(intent);
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });
    }

    private void rotateAnimation() {
        rotateAnimation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        mImageView.startAnimation(rotateAnimation);
    }
}
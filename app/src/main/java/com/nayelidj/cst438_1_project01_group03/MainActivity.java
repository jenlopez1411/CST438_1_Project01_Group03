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
    private Button button;
    private Button mcreateAcctBtn;
    private Button mLoginBtn;
    Animation rotateAnimation;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.searchPagebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSearchPage();
            }
        });

        mImageView = (ImageView)findViewById(R.id.jobHuntImageView);
        rotateAnimation();
        mcreateAcctBtn = findViewById(R.id.createAcctbtn);
        mcreateAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCreateAccount();
            }
        });

        mLoginBtn = findViewById(R.id.loginbtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginPage();
            }
        });
    }


    private void rotateAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        mImageView.startAnimation(rotateAnimation);
    }

    public void goToSearchPage() {
        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }

    public void goToCreateAccount() {
        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(intent);
    }

    public void goToLoginPage() {
        Intent intent = new Intent(MainActivity.this, LogIn.class);
        startActivity(intent);

    }
}
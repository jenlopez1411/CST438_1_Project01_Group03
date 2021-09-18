package com.nayelidj.cst438_1_project01_group03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class LogIn extends AppCompatActivity {
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mbtn;
    private Button mHomeBtn;
    private String username = "";
    private String password = "";
    private UserDao mCreateDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getDatabase();
        mUsernameField = findViewById(R.id.enterUsernameEditText);
        mPasswordField = findViewById(R.id.enterPasswordEditText);
        mbtn = findViewById(R.id.loginButton);
        mHomeBtn = findViewById(R.id.HomeBtn);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = mUsernameField.getText().toString();
                password = mPasswordField.getText().toString();
                if(checkInDB()){
                    Intent intent = new Intent(LogIn.this, SearchPage.class);
                    Toast.makeText(getApplicationContext(), "Passed login", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    mUsernameField.setError("Create an account!");
                }
            }
        });

        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private boolean checkInDB(){
        List<User> acct = mCreateDao.getAllUsers();
        for(User acc: acct){
            if(username.trim().equals(acc.getUserName().trim())){
                return true;
            }
        }
        return false;
    }
    public void getDatabase(){
        mCreateDao = Room.databaseBuilder(this, UserDatabase.class, UserDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getUserDao();
    }
}

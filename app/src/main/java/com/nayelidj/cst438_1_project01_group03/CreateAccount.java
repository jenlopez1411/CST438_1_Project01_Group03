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

public class CreateAccount extends AppCompatActivity {
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mButton;
    private String mUsername;
    private String mPassword;
    private UserDao mCreateDao;
    private Button mHomeBtn;
//    HomeButton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        getDatabase();
        mButton = findViewById(R.id.submitBtn);
        mHomeBtn = findViewById(R.id.HomeButton);

        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(i);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsernameField = findViewById(R.id.usernameEditText);
                mPasswordField = findViewById(R.id.passwordEditText);
                mUsername = mUsernameField.getText().toString();
                mPassword = mPasswordField.getText().toString();
                if(checkUserInDB()){
                    Toast.makeText(getApplicationContext(), "Already " + mUsername + " exists", Toast.LENGTH_LONG).show();
                }else{
                    if(checkValidUsername()){
                        if(checkValidPassword()){
                            User acct = new User(mUsername, mPassword);
                            mCreateDao.insert(acct);
                            Toast.makeText(getApplicationContext(), "Account Created Successfully!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(CreateAccount.this, LogIn.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Password Error: Not Valid Password", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Username Error: Not Valid Username", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

    }


    private boolean checkUserInDB(){
        List<User> acct = mCreateDao.getAllUsers();
        for(User acc: acct){
            if(mUsername.trim().equals(acc.getUserName().trim())){
                return true;
            }
        }
        return false;
    }

    private boolean checkValidUsername(){
        if(mUsername.trim().length() >= 4){
            return true;
        }
        return false;
    }

    private boolean checkValidPassword(){
        if(mPassword.trim().length() >= 4){
            return true;
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

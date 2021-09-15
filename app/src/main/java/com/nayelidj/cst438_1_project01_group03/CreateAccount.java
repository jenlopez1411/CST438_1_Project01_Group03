package com.nayelidj.cst438_1_project01_group03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class CreateAccount extends AppCompatActivity {
    public static final String TAG = "CreateAccount";
    private EditText mUsernameField;
    private EditText mPasswordField;
    private Button mButton;
    private Button mHomebtn;
    private String username = "";
    private String password = "";
    private UserDao mCreateDao;
    private List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        getDatabase();
        user = mCreateDao.getAllUsers();
        mUsernameField = findViewById(R.id.username);
        mPasswordField = findViewById(R.id.password);
        mButton = findViewById(R.id.submitBtn);
        mHomebtn = findViewById(R.id.HomeButton);
        Log.v(TAG, mUsernameField.getText().toString() + " musername");
        Log.v(TAG, mUsernameField.getText().toString());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, username);
                username = String.valueOf(mUsernameField.getText());
                password = mPasswordField.getText().toString();
                Log.i(TAG, "Submit button");
                if(checkUserInDB()){
                    Log.i(TAG, "Already There");
                    Toast.makeText(getApplicationContext(), "Already " + username + " exists", Toast.LENGTH_LONG).show();
                }else{
                    if(checkValidUsername()){
                        Log.i(TAG, "Valid Username");
                        if(checkValidPassword()){
                            Log.i(TAG, "Account Existed successfully");
                            User acct = new User(username, password);
                            mCreateDao.insert(acct);
                            Toast.makeText(getApplicationContext(), "Account Created Successfully!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(CreateAccount.this, LogIn.class);
                            startActivity(intent);
                        }else{
                            Log.i(TAG, "Error Password");
                            mPasswordField.setError("Password must be greater than size 3");
                        }
                    }else{
                        Log.i(TAG, "Error username");
                        mUsernameField.setError("Username must be greater than size 3");
                    }
                }
            }
        });

        mHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    private boolean checkUserInDB(){
        List<User> acct = mCreateDao.getAllUsers();
        for(User acc: acct){
            if(username.trim().equals(acc.getUserName().trim())){
                return true;
            }
        }
        return false;
    }

    private boolean checkValidUsername(){

        return (username.trim().length()) >= 4;
    }

    private boolean checkValidPassword(){
        return password.trim().length() >= 4;
    }
    public void getDatabase(){
        mCreateDao = Room.databaseBuilder(this, UserDatabase.class, UserDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getUserDao();
    }
}

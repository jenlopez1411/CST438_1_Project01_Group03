package com.nayelidj.cst438_1_project01_group03;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
    }
    public void searchB(View view){
        Context context = getApplicationContext();
        EditText userInput = findViewById(R.id.searchBar);
        String userInputV = String.valueOf(userInput.getText());

    }
    public void pageBtn(View view){
        Context context = getApplicationContext();
        EditText pageNumber = findViewById(R.id.pageNum);
        String pageNumberInput = String.valueOf(pageNumber.getText());
    }
}

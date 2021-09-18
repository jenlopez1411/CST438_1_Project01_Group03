package com.nayelidj.cst438_1_project01_group03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FavPageDisplay extends AppCompatActivity {
    private FavoriteDB fdb;
    public List<Favorite> favoriteList;
    public ArrayAdapter<Favorite> FavoriteAdapter;

    private Button doneButton;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_job_posts);
        fdb = FavoriteDB.getInstance(this);
        favoriteList = fdb.FavD().getAllFavorite();
        textViewResult = findViewById(R.id.text_view_result);

        updateUI();

        int i = 1;
        for (Favorite favorite : favoriteList)
        {
            textViewResult.append(String.valueOf(i));
            textViewResult.append("\n\n");
            textViewResult.append(favorite.toString());
            i++;
        }

        doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returntoMain();
            }
        });
    }
    private void updateUI() {
        favoriteList = fdb.FavD().getAllFavorite();
        if (FavoriteAdapter == null) {
            FavoriteAdapter = new ArrayAdapter<>(this, R.layout.activity_favorites, R.id.favoritesPageNew, favoriteList);
        } else {
            FavoriteAdapter.clear();
            FavoriteAdapter.addAll(favoriteList);
            FavoriteAdapter.notifyDataSetChanged();
        }
    }

    private void returntoMain()
    {
        Intent intent = new Intent(FavPageDisplay.this, MainActivity.class);
        startActivity(intent);
    }
}

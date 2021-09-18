package com.nayelidj.cst438_1_project01_group03;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FavPageDisplay extends AppCompatActivity {
    private FavoriteDB fdb;
    public ListView favListView;
    public List<Favorite> favoriteList;
    public ArrayAdapter<Favorite> FavoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_job_posts);
        fdb = FavoriteDB.getInstance(this);
        favoriteList = fdb.FavD().getAllFavorite();
        favListView = findViewById(R.id.list_favorites);

        updateUI();

    }
    private void updateUI() {
        favoriteList = fdb.FavD().getAllFavorite();
        if (FavoriteAdapter == null) {
            FavoriteAdapter = new ArrayAdapter<>(this, R.layout.activity_favorites, R.id.favoritesPageNew, favoriteList);
            favListView.setAdapter(FavoriteAdapter);
        } else {
            FavoriteAdapter.clear();
            FavoriteAdapter.addAll(favoriteList);
            FavoriteAdapter.notifyDataSetChanged();
        } }
}

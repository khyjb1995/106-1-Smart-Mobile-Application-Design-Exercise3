package com.example.khy_j.a410321171_exercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lstPlace;

    String[] strPlaces = new String[0];
    String[] strDetails = new String[0];
    String[] strPics = new String[0];
    String[] strMapsLocX = new String[0];
    String[] strMapsLocY = new String[0];
    String[] strWeb = new String[0];
    String[] strPhone = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

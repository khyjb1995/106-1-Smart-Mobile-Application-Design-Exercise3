package com.example.khy_j.a410321171_exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by khy_j on 2017/11/13.
 */

public class DetailsActivity extends AppCompatActivity {
    private TextView txtPlace;
    private TextView txtDetail;
    private ImageView imgPic;
    private ImageButton btnMap;
    private ImageButton btnWeb;
    private ImageButton btnCall;
    private Button btnReturn;

    String strPlaces;
    String strDetails;
    String strPics;
    Float strMapsLocX;
    Float strMapsLocY;
    String strWeb;
    Integer strPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datails);

        txtPlace = (TextView)findViewById(R.id.textView_place) ;
        txtDetail = (TextView)findViewById(R.id.textView_detail) ;
        imgPic = (ImageView)findViewById(R.id.imageView_pic);
        btnMap = (ImageButton)findViewById(R.id.imageButton_map);
        btnWeb = (ImageButton)findViewById(R.id.imageButton_web);
        btnCall = (ImageButton)findViewById(R.id.imageButton_call);

        // 取得 bundle
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        strPlaces = bundle.getString("PLACE");
        strDetails = bundle.getString("DETAIL");
        strPics = bundle.getString("PIC");
        strMapsLocX = bundle.getFloat("MAPX");
        strMapsLocY = bundle.getFloat("MAPY");
        strWeb = bundle.getString("WEB");
        strPhone = bundle.getInt("PHONE");


    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}

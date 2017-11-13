package com.example.khy_j.a410321171_exercise3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
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
    private ImageButton btnCamera;
    private Button btnReturn;

    String strCitys;
    String strPlaces;
    String strDetails;
    Integer intPics;
    Double strMapsLocX;
    Double strMapsLocY;
    String strWeb;
    String strPhone;

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
        btnCamera = (ImageButton)findViewById(R.id.imageButton_camera);

        // 取得 bundle

        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        strCitys = bundle.getString("CITY");
        strPlaces = bundle.getString("PLACE");
        strDetails = bundle.getString("DETAIL");
        intPics = bundle.getInt("PIC");
        strMapsLocX = bundle.getDouble("MAPX");
        strMapsLocY = bundle.getDouble("MAPY");
        strWeb = bundle.getString("WEB");
        strPhone = bundle.getString("PHONE");

        txtPlace.setText(strPlaces);
        txtDetail.setText(strDetails);
        txtDetail.setMovementMethod(new ScrollingMovementMethod());
        imgPic.setImageResource(intPics);
        imgPic.setScaleType(ImageView.ScaleType.CENTER_CROP);

        btnMap.setOnClickListener(btnMapListener);
        btnWeb.setOnClickListener(btnWebListener);
        btnCall.setOnClickListener(btnCallListener);
        btnCamera.setOnClickListener(btnCameraListener);
    }

    private ImageButton.OnClickListener btnMapListener = new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + strMapsLocX + "," + strMapsLocY + "(" + strPlaces + ")");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
    };

    private ImageButton.OnClickListener btnWebListener = new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(Uri.parse(strWeb));
            startActivity(webIntent);
        }
    };

    private ImageButton.OnClickListener btnCallListener = new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + strPhone));
            startActivity(callIntent);
        }
    };

    private ImageButton.OnClickListener btnCameraListener = new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

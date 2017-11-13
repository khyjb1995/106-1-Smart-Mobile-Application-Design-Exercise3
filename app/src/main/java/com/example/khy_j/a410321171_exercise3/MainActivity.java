package com.example.khy_j.a410321171_exercise3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lstPlace;

    String[] strCitys = new String[0];
    String[] strPlaces = new String[0];
    String[] strDetails = new String[0];
    String[] strPics = new String[0];
    Float[] strMapsLocX = new Float[0];
    Float[] strMapsLocY = new Float[0];
    String[] strWeb = new String[0];
    Integer[] strPhone = new Integer[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPlace = (ListView)findViewById(R.id.listView_place);

        strCitys[0] = "花蓮縣";
        strPlaces[0] = "七星潭海岸風景區";

        ArrayAdapter<String> adapterDatas = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_2,strPlaces);
        lstPlace.setAdapter(adapterDatas);
    }

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,DetailsActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("CITY", strCitys[i]);
            bundle.putString("PLACE", strPlaces[i]);
            bundle.putString("DETAIL", strDetails[i]);
            bundle.putString("PIC", strPics[i]);
            bundle.putFloat("MAPX", strMapsLocX[i]);
            bundle.putFloat("MAPY", strMapsLocY[i]);
            bundle.putString("WEB", strWeb[i]);
            bundle.putInt("PHONE", strPhone[i]);

            startActivity(intent);
        }
    };
}

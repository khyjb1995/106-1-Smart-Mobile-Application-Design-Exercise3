package com.example.khy_j.a410321171_exercise3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lstPlace;

    int data = 4;
    String[] strCitys = new String[data];
    String[] strPlaces = new String[data];
    String[] strDetails = new String[data];
    Integer[] intPics = new Integer[data];
    Double[] strMapsLocX = new Double[data];
    Double[] strMapsLocY = new Double[data];
    String[] strWeb = new String[data];
    String[] strPhone = new String[data];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPlace = (ListView)findViewById(R.id.listView_place);
        MyAdapter adapter=new MyAdapter(this);

        int i = 0;
        strCitys[i]    = "花蓮縣新城鄉";
        strPlaces[i]   = "七星潭海濱公園";
        strDetails[i]  = "七星潭是花蓮縣唯一的縣級風景區，乍聽之下似乎是一個星星狀的湖泊地形，但初到七星潭，肯定會被那新月型的海灣給迷惑，又稱月牙灣的七星潭是個湛藍的礫石海灣，海灣的末端依著高聳的中央山脈，那幅山海邂逅的畫面讓多少人為此陶醉。";
        intPics[i]     = R.drawable.hlqxt;
        strMapsLocX[i] = 24.0310359;
        strMapsLocY[i] = 121.6265048;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005030001&u=Intro&area=2&id=38";
        strPhone[i]    = "038221592";


        lstPlace.setAdapter(adapter);
        lstPlace.setOnItemClickListener(lstPreferListener);

    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return strCitys.length;
        }
        @Override
        public Object getItem(int position){
            return strCitys[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            convertView = myInflater.inflate(R.layout.place_layout, null);

            TextView txtCity = ((TextView) convertView.findViewById(R.id.txtCity));
            TextView txtPlace = ((TextView) convertView.findViewById(R.id.txtPlace));

            txtCity.setText(strCitys[position]);
            txtPlace.setText(strPlaces[position]);

            return convertView;
        }
    }

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent=new Intent();
            intent.setClass(MainActivity.this,DetailsActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("CITY", strCitys[i]);
            bundle.putString("PLACE", strPlaces[i]);
            bundle.putString("DETAIL", strDetails[i]);
            bundle.putInt("PIC", intPics[i]);
            bundle.putDouble("MAPX", strMapsLocX[i]);
            bundle.putDouble("MAPY", strMapsLocY[i]);
            bundle.putString("WEB", strWeb[i]);
            bundle.putString("PHONE", strPhone[i]);
            intent.putExtras(bundle);

            startActivity(intent);


        }
    };
}

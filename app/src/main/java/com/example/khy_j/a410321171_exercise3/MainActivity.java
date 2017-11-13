package com.example.khy_j.a410321171_exercise3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    int data = 5;
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
        lstPlace.setTextFilterEnabled(true);
        lstPlace.setSelector(android.R.color.holo_orange_light);

        int i = 0;
        strCitys[i]    = "HUALIEN 花蓮縣新城鄉";
        strPlaces[i]   = "七星潭海濱公園";
        strDetails[i]  = "七星潭是花蓮縣唯一的縣級風景區，乍聽之下似乎是一個星星狀的湖泊地形，但初到七星潭，肯定會被那新月型的海灣給迷惑，又稱月牙灣的七星潭是個湛藍的礫石海灣，海灣的末端依著高聳的中央山脈，那幅山海邂逅的畫面讓多少人為此陶醉。\n" +
                "\n" +
                "位於新城鄉東北角海濱的七星潭，除了弧形海灣令人著迷外，海水潔淨蔚藍，清晰可見浪濤中的石礫，原本只是一處平靜的小漁村，因擁有得天獨厚的自然地理環境，加上簡單的賞景步道、海邊亭台、觀日月樓、賞星廣場等設施，讓遊客都能盡情徜徉於碧海藍天之中。夜間無光害的海灘無論賞星、賞月或只是單純想聽聽石礫與海濤的歌唱都是最佳選擇。";
        intPics[i]     = R.drawable.hlqxt;
        strMapsLocX[i] = 24.0310359;
        strMapsLocY[i] = 121.6265048;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005030001&u=Intro&area=2&id=38";
        strPhone[i]    = "038221592";

        i = 1;
        strCitys[i]    = "HUALIEN 花蓮縣秀林鄉";
        strPlaces[i]   = "清水斷崖風景區";
        strDetails[i]  = "清水斷崖位於蘇花公路和仁至崇德之間，長約12公里的路段。其中清水山東南大斷崖，絕壁臨海面長達5公里，非常壯觀。行於此路段，呈現眼前的險峻的殘岩斷壁與無垠無際的汪洋萬頃，而如此驚險的路段也讓人不禁緬懷拓荒者的艱辛，如同閱讀山海與人之間驚心動魄的感人篇章。\n" +
                "\n" +
                "重新改建的蘇花公路段，大多已開鑿新隧道來拓寬道路，而依傍一旁的蘇花公路臨海舊道，便成為適合樂活散步的觀景步道。步行其中，俯瞰奇岩峭壁與岸上拍打的粼粼浪花，內心充滿感嘆驚奇，而壯麗的風情也堪稱為台灣八大美景之一。";
        intPics[i]     = R.drawable.qsdy;
        strMapsLocX[i] = 24.15762;
        strMapsLocY[i] = 121.621614;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005020001&u=Intro&area=1&id=56";
        strPhone[i]    = "038621100";

        i = 2;
        strCitys[i]    = "HUALIEN 花蓮縣光復鄉";
        strPlaces[i]   = "花蓮觀光糖廠";
        strDetails[i]  = "民國2年「東台製糖株式會社」在花蓮縣壽豐鄉設立「花蓮港製糖所」，又稱為「鯉魚尾糖廠」；民國10年另在光復鄉設立「大和工廠」，以擴大製糖產量。二次大戰末期，這兩處糖廠均遭盟軍毀損。光復後，台糖公司接收，決定拆除毀損較嚴重的壽豐工廠，修復大和工廠並更名為花蓮糖廠，成為東部地區的製糖重心。由於糖廠位於光復鄉，因此常被稱為「光復糖廠」，其實「花蓮糖廠」才是它正式的名稱。 \n" +
                "\n" +
                "花蓮糖廠歷經數十年的擴建與更新，製糖產量與品質大幅提升，而為了供應花蓮糖廠的製糖原料，北起新城鄉，南至富里鄉，都可見到廣闊的甘蔗田，成為花東縱谷裡的特殊景觀。除了生產砂糖之外，花蓮糖廠冰品部裡各種口味的冰棒與冰淇淋更是廣受歡迎，無論是外地遊客或本地人，「到糖廠吃冰」早已成為大家心中充滿歡樂氣氛的共同記憶。";
        intPics[i]     = R.drawable.hlggtc;
        strMapsLocX[i] = 23.656553;
        strMapsLocY[i] = 121.420805;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005020001&u=Intro&area=4&id=51";
        strPhone[i]    = "038705881";

        i = 3;
        strCitys[i]    = "HUALIEN 花蓮縣花蓮市";
        strPlaces[i]   = "花蓮創意文化園區";
        strDetails[i]  = "由花蓮舊酒廠修整而成的花蓮文創產業園區是文建會在台灣推動的五大文化創意產業園區之一。位於花蓮市區精華地段的園區擁有廣大的腹地，昔日的釀酒廠房依舊存在，林立於園區內，但轉型為釀製創意文化之芬芳場域，樸實無華的設計反而呈現出過去酒廠的風貌，是遊客拍照、參訪散步的好去處。\n" +
                "\n" +
                "園區內各式的廠房經過改造後紛紛成為藝術空間，在老舊的外表下蘊藏著是文化意涵，舉凡展覽場、小劇場、倉庫、辦公廳無一不有懷舊風與現代感同時呈現的步調，也是花蓮許多重要藝文活動發生的地方，有興趣的遊客不妨走走看看，說不定會有意想不到的驚喜展覽唷！";
        intPics[i]     = R.drawable.hlcywhyq;
        strMapsLocX[i] = 23.976195;
        strMapsLocY[i] = 121.604442;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005040001&u=Intro&area=3&id=67";
        strPhone[i]    = "038313777";

        i = 4;
        strCitys[i]    = "HUALIEN 花蓮縣豐濱鄉";
        strPlaces[i]   = "豐濱天空步道";
        strDetails[i]  = "位於台11線新豐隧道外的「親不知子斷崖」，緣著斷崖絕壁而建的棧道，全長約150公尺，一次僅十人進入，其中有20公尺路段採用強化透明玻璃棧道，距離海面約40公尺，一邊是山景，一邊是太平洋，腳下的萬丈深淵更是一覽無遺。\n" +
                "\n" +
                "早年穿越父子斷崖(親不知子斷崖)的原住民步道，與廢棄的新磯隧道平行，長度也相當。古道在1971年(民國60年)左右荒廢後，在豐濱鄉公所的努力下，重新打造了一條新的天空步道，並於步道附近規劃了大型停車場和公園綠地，方便民眾休憩遊玩。";
        intPics[i]     = R.drawable.fbtkbd;
        strMapsLocX[i] = 23.675376;
        strMapsLocY[i] = 121.545538;
        strWeb[i]      = "http://tour-hualien.hl.gov.tw/Portal/Content.aspx?lang=0&p=005060001&u=Intro&area=5&id=214";
        strPhone[i]    = "038791350";


        lstPlace.setAdapter(adapter);
        lstPlace.setOnItemClickListener(lstPreferListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_about:
                AlertDialog.Builder adbView = new AlertDialog.Builder(MainActivity.this);
                adbView.setTitle("關於About")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("簡浩揚 設計\nDesign by KARN HOW YONG\nID: 410321171")
                        .show();
                break;
            case R.id.menu_quit:
                finish();
                break;
        }
        return  super.onOptionsItemSelected(item);
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

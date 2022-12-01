package com.example.app_tieng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TiengCacNuoc> arrayList;
    AdapterTieng adapterTieng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        arrayList = new ArrayList<>();
        ListView listView =(ListView)findViewById(R.id.lvcacnuoc);
        arrayList.add(new TiengCacNuoc("Việt Nam"));
        arrayList.add(new TiengCacNuoc("Anh Quốc"));
        arrayList.add(new TiengCacNuoc("Trung Quốc"));
        arrayList.add(new TiengCacNuoc("Lào"));
        arrayList.add(new TiengCacNuoc("Hàn"));
        arrayList.add(new TiengCacNuoc("Thái Lan"));
        arrayList.add(new TiengCacNuoc("Philipins"));
        adapterTieng = new AdapterTieng(MainActivity.this, R.layout.item_lvmain, arrayList);
        listView.setAdapter((ListAdapter) adapterTieng);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    startActivity(new Intent(MainActivity.this, TiengViet.class));
                }else if(i ==1){
                    startActivity(new Intent(MainActivity.this,TiengAnh.class));
                }else if(i ==2){
                    startActivity(new Intent(MainActivity.this,TiengTrung.class));
                }else if(i ==3){
                    startActivity(new Intent(MainActivity.this,TiengLao.class));
                }else if(i ==4){
                    startActivity(new Intent(MainActivity.this,TiengHan.class));
                }else if(i ==5){
                    startActivity(new Intent(MainActivity.this,TiengThai.class));
                }else{
                    startActivity(new Intent(MainActivity.this,TiengThai.class));
                }
            }
        });
    }

}
package com.example.baikt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
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
        arrayList.add(new TiengCacNuoc("Mỹ"));
        arrayList.add(new TiengCacNuoc("Campuchia"));
        arrayList.add(new TiengCacNuoc("Philipins"));
        adapterTieng = new AdapterTieng(MainActivity.this, R.layout.item_list_thi, arrayList);
        listView.setAdapter(adapterTieng);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    startActivity(new Intent(MainActivity.this, VietActivity.class));
                }else if(i ==1){
                    startActivity(new Intent(MainActivity.this,AnhActivity.class));
                }else if(i ==2){
                    startActivity(new Intent(MainActivity.this,TrungActivity.class));
                }else if(i ==3){
                    startActivity(new Intent(MainActivity.this,LaoActivity.class));
                }else if(i ==4){
                    startActivity(new Intent(MainActivity.this,MyActivity.class));
                }else if(i ==5){
                    startActivity(new Intent(MainActivity.this,CampuchiaActivity.class));
                }else{
                    startActivity(new Intent(MainActivity.this,PhilipinsActivity.class));
                }
            }
        });
    }
}
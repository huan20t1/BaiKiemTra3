package com.example.app_tieng;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TiengLao extends AppCompatActivity {
    EditText edtso1;
    ListView lvkq;
    Button btbvd;
    private ListView lvDulieu;
    private ArrayList<DuLieu> duLieuArrayList;
    private  DuLieuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienglao);


        edtso1 = findViewById(R.id.tl_1);
        btbvd = findViewById(R.id.bt_push);

        lvDulieu = findViewById(R.id.lvvd);

        duLieuArrayList = new ArrayList<>();
        getData();
        adapter = new DuLieuAdapter(this,R.layout.item_list,duLieuArrayList);
        lvDulieu.setAdapter(adapter);

        addEvents();
        addControls();

    }
    private  void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("QuanLyNgonNgu");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear();
                for(DataSnapshot data : snapshot.getChildren()){
                    DuLieu duLieu = data.getValue(DuLieu.class);
                    if(duLieu != null){
                        duLieu.setId(data.getKey());
                        adapter.add(duLieu);
                    }
                }
                Toast.makeText(getApplicationContext(),"Thành công !",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Thất bại !" + error.toString(),Toast.LENGTH_SHORT).show();
                Log.d("MYTAG","onCancelled: " + error.toString());
            }
        });
    }
    private void addEvents() {
        btbvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String so1 = edtso1.getText().toString();


                DuLieu duLieu =new DuLieu(so1);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("QuanLyNgonNgu");
                String id = myRef.push().getKey();
                myRef.child(id).setValue(duLieu).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Thêm thành công  !",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Thêm thất bại !",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
    private void addControls() {
        edtso1 = findViewById(R.id.tl_1);
        lvkq = findViewById(R.id.lvvd);
        btbvd = findViewById(R.id.bt_push);
    }
}
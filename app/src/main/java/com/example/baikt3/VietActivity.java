package com.example.baikt3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VietActivity extends AppCompatActivity {
    EditText textvidu;
    Button btsave;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet);
        getSupportActionBar().hide();

        btsave = findViewById(R.id.btnluu);
        textvidu = findViewById(R.id.edtvidu);
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vidu = textvidu.getText().toString().trim();
                ViDu viDu = new ViDu(vidu);
                onClickPushData(viDu);
            }
        });

        img= findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VietActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void onClickPushData(ViDu user){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Tree");

        String pathObject = String.valueOf(user.getVidu());
        myRef.child(pathObject).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(VietActivity.this,"Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
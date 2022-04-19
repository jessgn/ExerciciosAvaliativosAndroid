package com.example.matematicadivertida;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aritmetica (View view){
        Intent it = new Intent(this, Aritmetica.class);
        startActivity(it);
    }

    public void maiorNum (View view){
        Intent it = new Intent(this, Advinhe.class);
        startActivity(it);
    }

}
package com.fotl.development.mtgkotlintrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fotl.development.mtgkotlintrail.View.PlayerLayout4Activity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gameSelect(View view){
        Intent intent = new Intent(this, PlayerLayout4Activity.class);
        startActivity(intent);
    }
}

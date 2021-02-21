package com.example.exercise3button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static Clicks clicks;

    private String clicksString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clicks = new Clicks();
        setContentView(R.layout.activity_main);
    }

    public void onStart(){
        super.onStart();
        updateView();
    }

    public void updateView(){
        clicksString = String.valueOf(clicks.getClicks());
        Button button = (Button) findViewById(R.id.btn_1);
        button.setText(clicksString);
    }

    public void incrementScreen(View view){
        Intent myIntent = new Intent(this, ActionActivity.class);
        this.startActivity(myIntent);
    }
}
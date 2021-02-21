package com.example.exercise3button;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActionActivity extends AppCompatActivity {
    Clicks clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
    }

    public void updateMain(){
        clicks = MainActivity.clicks;
        int temp = clicks.getClicks();
        clicks.setClicks(temp += 1);
    }

    public void goBack(View view){
        updateMain();
        this.finish();
    }
}

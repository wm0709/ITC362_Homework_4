package com.example.mortgagecalc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    public static final String DA = "MainActivity";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }

    public void updateView(){
        Mortgage mortgage = MainActivity.mortgage;
        if(mortgage.getYears() == 10){
            RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
            rb10.setChecked(true);
        } else if(mortgage.getYears() == 15){
            RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);
            rb15.setChecked(true);
        } // else do nothing (default is 30)

        EditText amountET = (EditText) findViewById(R.id.data_amount);
        amountET.setText("" + mortgage.getAmount());
        EditText rateET = (EditText) findViewById(R.id.data_rate);
        rateET.setText("" + mortgage.getRate());
    }

    public void updateMortgageObject(){
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
        RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);
        int years = 30;
        if(rb10.isChecked())
            years = 10;
        else if(rb15.isChecked())
            years = 15;
        mortgage.setYears(years);
        EditText amountET = (EditText) findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();
        EditText rateET = (EditText) findViewById(R.id.data_rate);
        String rateString = rateET.getText().toString();
        try{
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);
            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);
            mortgage.setPreferences(this);
        } catch(NumberFormatException nfe){
            mortgage.setAmount(100000.0f);
            mortgage.setRate(.035f);
        }
    }

    public void goBack(View v){
        updateMortgageObject();
        this.finish();
        overridePendingTransition(R.anim.fade_in_and_scale, 0);
    }

    protected void onStart(){
        super.onStart();
        Log.w(DA,"Inside MainActivity:onStart\n");
    }

    protected void onRestart(){
        super.onRestart();
        Log.w(DA,"Inside MainActivity:onRestart\n");
    }

    protected void onResume(){
        super.onResume();
        Log.w(DA,"Inside MainActivity:onResume\n");
    }

    protected void onPause(){
        super.onPause();
        Log.w(DA,"Inside MainActivity:onPause\n");
    }

    protected void onStop(){
        super.onStop();
        Log.w(DA,"Inside MainActivity:onStop\n");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.w(DA,"Inside MainActivity:onDestroy\n");
    }
}

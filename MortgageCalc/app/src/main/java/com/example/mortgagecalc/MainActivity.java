package com.example.mortgagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String MA = "MainActivity";
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage(this);
        setContentView(R.layout.activity_main);
    }

    protected void onStart(){
        super.onStart();
        updateView();
    }

    public void updateView(){
        TextView amountTV = (TextView) findViewById(R.id.amount);
        amountTV.setText(mortgage.getFormattedAmount());
        TextView yearsTV = (TextView) findViewById(R.id.years);
        yearsTV.setText("" + mortgage.getYears());
        TextView rateTv = (TextView) findViewById(R.id.rate);
        rateTv.setText(100 * mortgage.getRate() + "%");
        TextView monthlyTV = (TextView) findViewById(R.id.payment);
        monthlyTV.setText(mortgage.formattedMonthlyPayment());
        TextView totalTV = (TextView) findViewById(R.id.total);
        totalTV.setText(mortgage.formattedTotalPayment());
    }

    public void modifyData(View view) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    protected void onRestart(){
        super.onRestart();
        Log.w(MA,"Inside MainActivity:onRestart\n");
    }

    protected void onResume(){
        super.onResume();
        Log.w(MA,"Inside MainActivity:onResume\n");
    }

    protected void onPause(){
        super.onPause();
        Log.w(MA,"Inside MainActivity:onPause\n");
    }

    protected void onStop(){
        super.onStop();
        Log.w(MA,"Inside MainActivity:onStop\n");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.w(MA,"Inside MainActivity:onDestroy\n");
    }
}
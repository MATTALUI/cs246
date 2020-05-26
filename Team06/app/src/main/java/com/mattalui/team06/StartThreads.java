package com.mattalui.team06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartThreads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_threads);
    }

    public void startEvens(View v) {
        Thread evenThread = new Thread(new EvenCounter(this));
        evenThread.start();
    }

    public void startOdds(View v) {
        Thread oddThread = new Thread(new OddCounter(this));
        oddThread.start();
    }
}

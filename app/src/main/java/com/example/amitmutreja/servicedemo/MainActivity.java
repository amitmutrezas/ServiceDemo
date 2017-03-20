package com.example.amitmutreja.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startServiceOnUIThread(View view) {
        Intent intent = new Intent(this, ServiceOnUIThread.class);
        startService(intent);
    }

    public void stopServiceOnUIThread(View view) {
        Intent intent = new Intent(this, ServiceOnUIThread.class);
        stopService(intent);
    }

    public void startServiceOnWorkerThread(View view) {
        Intent intent = new Intent(this, ServiceOnWorkerThread.class);
        startService(intent);
    }

    public void stopServiceOnWorkerThread(View view) {
        Intent intent = new Intent(this, ServiceOnWorkerThread.class);
        stopService(intent);
    }
}

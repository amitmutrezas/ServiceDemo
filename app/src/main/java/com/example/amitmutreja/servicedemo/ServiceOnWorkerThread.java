package com.example.amitmutreja.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceOnWorkerThread extends Service {
    public ServiceOnWorkerThread() {
    }

    private final class WorkerServiceThread implements Runnable {
        int serviceId;

        public WorkerServiceThread(int serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            stopSelf(this.serviceId);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(ServiceOnWorkerThread.this, "service STARTED", Toast.LENGTH_LONG).show();
        Thread thread = new Thread(new WorkerServiceThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(ServiceOnWorkerThread.this, "service STOPPED", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

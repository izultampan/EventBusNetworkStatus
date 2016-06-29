package com.abhimantrass.eventbuslearning;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.net.ConnectivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abhimantrass.eventbuslearning.service.NetworkReceiver;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkReceiver receiver = new NetworkReceiver();
        registerReceiver(receiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
}

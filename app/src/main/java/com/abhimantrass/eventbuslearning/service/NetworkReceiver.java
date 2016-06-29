package com.abhimantrass.eventbuslearning.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.abhimantrass.eventbuslearning.model.NetworkModel;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by zul on 6/29/2016.
 */
public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null) return;

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();

        int currentConnection = NetworkModel.NO_CONNECTION;
        boolean connection = false;
        if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED) {

            connection = true;
            NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (wifi.isConnected()){
                currentConnection = NetworkModel.WIFI_CONNECTION;
            }

            if (mobile.isConnected()) {
                currentConnection = NetworkModel.MOBILE_CONNECTION;
            }
            NetworkModel model = new NetworkModel(currentConnection, connection);
            EventBus.getDefault().post(model);
        }
        else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)) {
            NetworkModel model = new NetworkModel(currentConnection, connection);
            EventBus.getDefault().post(model);
        }
    }
}

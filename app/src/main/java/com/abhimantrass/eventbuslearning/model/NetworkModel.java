package com.abhimantrass.eventbuslearning.model;

/**
 * Created by zul on 6/29/2016.
 */
public class NetworkModel {

    public static final int NO_CONNECTION = -1;
    public static final int WIFI_CONNECTION = 0;
    public static final int MOBILE_CONNECTION = 1;

    private int networkState;
    private boolean connected;

    public NetworkModel(int networkState, boolean connected) {
        this.networkState = networkState;
        this.connected = connected;
    }
    public void setNetworkState(int networkState) {
        this.networkState = networkState;
    }
    public int getNetworkState() {
        return networkState;
    }
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    public boolean isConnected() {
        return connected;
    }
}

package com.abhimantrass.eventbuslearning.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.abhimantrass.eventbuslearning.R;
import com.abhimantrass.eventbuslearning.model.NetworkModel;

import de.greenrobot.event.EventBus;

/**
 * Created by zul on 6/29/2016.
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvStatus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.txt_status);

        EventBus.getDefault().register(this);
    }

    public void onEvent(NetworkModel model) {
        if (model != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.connection_status))
                    .append(model.isConnected());
            if (model.isConnected()) {
                sb.append(" ").append(getString(R.string.connect_with))
                        .append(model.getNetworkState() == NetworkModel.WIFI_CONNECTION ? getString(R.string.wifi_connection) : getString(R.string.mobile_connection));
            }

            tvStatus.setText(sb.toString());
        }
        else {
            tvStatus.setText(getString(R.string.no_internet_status));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

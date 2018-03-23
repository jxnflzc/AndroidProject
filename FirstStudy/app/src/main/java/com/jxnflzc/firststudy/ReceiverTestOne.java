package com.jxnflzc.firststudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ReceiverTestOne extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast t = Toast.makeText(context, R.string.broadcast_test_one, Toast.LENGTH_LONG);
        t.show();
    }
}

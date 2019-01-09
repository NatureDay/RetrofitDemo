package com.example.retrofittest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetWorkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        HttpNetUtil.INSTANCE.setConnected(context);
    }
}

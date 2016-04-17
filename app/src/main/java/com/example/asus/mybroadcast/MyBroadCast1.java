package com.example.asus.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Asus on 2016/4/17.
 */
public class MyBroadCast1 extends BroadcastReceiver {
    private static final String TAG="MyBroadCast1";
    @Override
    public void onReceive(Context context, Intent intent) {
//        String str=intent.getStringExtra("textView1");
////        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
//        Log.d(TAG,str);
        Bundle bundle=intent.getBundleExtra("bundle");
        Log.d(TAG,bundle.get("有序广播").toString());

    }
}

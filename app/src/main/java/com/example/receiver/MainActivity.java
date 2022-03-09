package com.example.receiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.broadcastreceiver.R;

/**
 * created by Arshadkhan......
 */
public class MainActivity extends AppCompatActivity {
    public static final String ACTION1 = "kya hua tera bada";
    public static final String ACTION2 = "mile ge hum ye din akhare ho ga";
    String TAG = "MainActivity";
    MyReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FragmentActivity()).commit();
        }
        mReceiver = new MyReceiver();
    }
    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION2));
    }
    @Override
    protected void onPause() {  //or onDestory()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        Log.v(TAG, "receiver should be unregistered");
        super.onPause();

    }
}
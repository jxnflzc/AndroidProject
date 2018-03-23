package com.jxnflzc.firststudy;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class SecDayActivity extends AppCompatActivity {
    private Button secBtnBroTes_1, secBtnBroTes_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_day);
        getSupportActionBar().hide();

        secBtnBroTes_1 = (Button)findViewById(R.id.btn_broadcast_test_one);
        secBtnBroTes_2 = (Button)findViewById(R.id.btn_broadcast_test_two);

        secBtnBroTes_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent BroadTestOne = new Intent("MBC");
                BroadTestOne.setComponent(new ComponentName("com.jxnflzc.firststudy","com.jxnflzc.firststudy.ReceiverTestOne"));
                sendBroadcast(BroadTestOne);
            }
        });

        secBtnBroTes_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent BroadTestTwo = new Intent("android.intent.action.VIEW");
                BroadTestTwo.setComponent(new ComponentName("com.android.camera","com.android.camera.Camera"));
                sendBroadcast(BroadTestTwo);
                Toast.makeText(SecDayActivity.this, R.string.broadcast_test_two, Toast.LENGTH_SHORT).show();
            }
        });

    }
    /*class ReceiverTestOne extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, R.string.btn_broadcast_test_one, Toast.LENGTH_LONG).show();
        }
    }*/

}

package com.jxnflzc.firststudy;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.text.method.*;

public class MainActivity extends AppCompatActivity {
    private Button mBtnFirDay, mBtnSecDay, mBtnThiDay;
    private IntentFilter mNetworkBroadcast;
    private NetworkChangeReceiver mNetworkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnFirDay = (Button)findViewById(R.id.btn_first_day);
        mBtnSecDay = (Button)findViewById(R.id.btn_second_day);
        mBtnThiDay = (Button)findViewById(R.id.btn_third_day);
        mNetworkBroadcast = new IntentFilter();
        mNetworkBroadcast.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetworkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(mNetworkChangeReceiver, mNetworkBroadcast);

        mBtnFirDay.setOnClickListener(new View.OnClickListener(){       //创建"第一天"按钮监听器
            @Override
            public void onClick(View v) {
                Intent gotoFirDayActivity = new Intent(MainActivity.this, FirDayActivity.class);//跳转到"第一天"界面
                startActivity(gotoFirDayActivity);
            }
        });

        mBtnSecDay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotoSecDayActivity = new Intent(MainActivity.this, SecDayActivity.class);//跳转到"第二天"界面
                startActivity(gotoSecDayActivity);
            }
        });

        mBtnThiDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoThiDayActivity = new Intent(MainActivity.this, ThiDayActivity.class);//跳转到"第三天"界面
                startActivity(gotoThiDayActivity);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetworkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null &&networkInfo.isAvailable()){
                Toast.makeText(context, R.string.wlan_turn_on, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, R.string.wlan_turn_off, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_info_item:
                AlertDialog.Builder app_info_dialog = new AlertDialog.Builder(MainActivity.this);
                app_info_dialog.setTitle(R.string.app_info_title);
                app_info_dialog.setMessage(R.string.app_info);
                app_info_dialog.setCancelable(false);
                app_info_dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                app_info_dialog.show();
                break;
            case R.id.version_item:
                AlertDialog.Builder version_dialog = new AlertDialog.Builder(MainActivity.this);
                version_dialog.setTitle(R.string.version_title);
                version_dialog.setMessage(R.string.version);
                version_dialog.setCancelable(false);
                version_dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                version_dialog.show();
                break;
            case R.id.about_us_item:
                AlertDialog.Builder about_us_dialog = new AlertDialog.Builder(MainActivity.this);
                about_us_dialog.setTitle(R.string.about_us_title);
                about_us_dialog.setMessage(R.string.about_us);
                about_us_dialog.setCancelable(false);
                about_us_dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                about_us_dialog.show();
                break;
            default:
        }
        return true;
    }
}
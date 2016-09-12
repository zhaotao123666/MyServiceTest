package com.example.myservicetest.ActivityModule;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myservicetest.R;
import com.lidroid.xutils.util.LogUtils;

/**
 * Created by 赵小缺 on 2016/9/10.
 */
public class BaseActivity extends Activity {
    public static boolean isRuning = false;
    private static TextView newsim;
    public static Handler refreshNewIMHandler;
    public static int i = 0;
    public static Class currentClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        refreshNewIMHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        i ++;
                        newsim.setVisibility(View.VISIBLE);
                        newsim.setText("有"+ i +"条新消息");
                        LogUtils.e(newsim.getText().toString());
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRuning = true;
        newsim = (TextView) findViewById(R.id.newIM);
        if (SecondActivity.hasNew) {
            newsim.setVisibility(View.VISIBLE);
            newsim.setText("有" + i + "条新消息");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRuning = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.example.myservicetest.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.example.myservicetest.ActivityModule.BaseActivity;
import com.example.myservicetest.ActivityModule.ThirdActivity;
import com.lidroid.xutils.util.LogUtils;

/**
 * Created by 赵小缺 on 2016/9/10.
 */
public class NewImReceiver extends BroadcastReceiver {
    public static int count = 0;
    @Override
    public void onReceive(Context context, Intent intent) {
//        if (BaseActivity.isRuning) {
//            count ++;
//            Message msg = Message.obtain();
//            msg.arg1 = count;
            BaseActivity.refreshNewIMHandler.sendEmptyMessage(1);
            LogUtils.e("接收到了");
//        }
    }
}

package com.example.myservicetest.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.myservicetest.ActivityModule.SecondActivity;
import com.example.myservicetest.ActivityModule.ThirdActivity;
import com.example.myservicetest.R;
import com.lidroid.xutils.util.LogUtils;

/**
 * Created by 赵小缺 on 2016/9/10.
 */

/**
 * 模拟发送消息
 */
public class SendMessageService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener{


    int i = 0;
    private Handler handler = new Handler();

    private MediaPlayer player;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i ++;
            android.os.Message msg = new android.os.Message();
            Bundle bundle = new Bundle();
            bundle.putString("newIM","你好"+ i);
            msg.setData(bundle);

            if (!SecondActivity.isRuning) {
                SecondActivity.hasNew = true;
                Intent in = new Intent("com.example.myservicetest.Service.NewImReceiver");
                sendBroadcast(in);
            }

            SecondActivity.refreshHandle.sendMessage(msg);
            //铃声
            ringAndVibrator();
            //5秒发送一次
            handler.postDelayed(runnable,5 * 1000);
            LogUtils.e("发送");
        }

        private void ringAndVibrator() {
            if (player == null) {
                player = MediaPlayer.create(SendMessageService.this, R.raw.ios3c);
                player.setOnPreparedListener(SendMessageService.this);
                player.setOnErrorListener(SendMessageService.this);
            }
            player.start();
            //震动
//            Vibrator vibrator = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
//            vibrator.vibrate(500);
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(runnable,5 * 1000);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
    }
}

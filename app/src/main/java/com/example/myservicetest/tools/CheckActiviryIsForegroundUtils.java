package com.example.myservicetest.tools;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;

/**
 * Created by steven on 16/5/19.
 */
public class CheckActiviryIsForegroundUtils {
    public static boolean isRunningForeground(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm.isScreenOn()) {
            return true;
        }
        return false;
    }
}

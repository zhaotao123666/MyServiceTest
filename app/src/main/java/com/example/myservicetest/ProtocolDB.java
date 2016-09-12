package com.example.myservicetest;

import android.content.Context;

import com.example.myservicetest.entities.ChatMessage;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

/**
 * Created by 赵小缺 on 2016/9/10.
 */
public class ProtocolDB {

   private static DbUtils mDataDB;
    public static void initDB(Context context) {
        String dir = context.getFilesDir().getAbsolutePath();
        mDataDB = DbUtils.create(context,dir,"setup.db");
    }

    public static void saveIM(String string) {
        ChatMessage newCM = new ChatMessage();
        newCM.setContent(string);
        try {
            mDataDB.save(ChatMessage.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}

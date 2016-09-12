package com.example.myservicetest.ActivityModule;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myservicetest.R;
import com.example.myservicetest.Service.SendMessageService;
import com.example.myservicetest.entities.ChatMessage;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    public static boolean hasNew = false;

//    private Intent in;

    private static List<ChatMessage> mlist = null;

    private ListView listView;

    public static ChatMessageAdapter mAdapter;

    private Button nextBtn;

    public static boolean isRuning = false;


    public static Handler refreshHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            String contentStr = bundle.getString("newIM");
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setContent(contentStr);

            mlist.add(chatMessage);

            mAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView) findViewById(R.id.lv_chat);
        mlist = new ArrayList<ChatMessage>();
        mAdapter = new ChatMessageAdapter(SecondActivity.this,mlist);
        listView.setAdapter(mAdapter);

        nextBtn = (Button) findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });

        Intent in = new Intent(SecondActivity.this, SendMessageService.class);
        startService(in);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hasNew = false;
        isRuning = true;
        BaseActivity.i = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRuning = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent in = new Intent(SecondActivity.this, SendMessageService.class);
        stopService(in);
    }

    private class ChatMessageAdapter extends BaseAdapter {

        private Context context;
        private List<ChatMessage> mlist;

        public ChatMessageAdapter(Context context, List<ChatMessage> mlist) {
            this.context = context;
            this.mlist = mlist;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int i) {
            return mlist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View layout, ViewGroup parent) {
            ViewHolder holder = null;
            if (layout == null) {
                holder = new ViewHolder();
                layout = View.inflate(context, R.layout.item_chatlist,null);
                holder.tvContent = (TextView) layout.findViewById(R.id.tv_chatContent);
                layout.setTag(holder);
            }else {
                holder = (ViewHolder) layout.getTag();
            }
            ChatMessage info = mlist.get(i);
            holder.tvContent.setText(info.getContent());
            return layout;
        }
    }

    class ViewHolder {
        TextView tvContent;
    }

}

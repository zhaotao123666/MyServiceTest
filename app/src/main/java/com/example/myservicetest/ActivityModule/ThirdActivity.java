package com.example.myservicetest.ActivityModule;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myservicetest.R;

public class ThirdActivity extends BaseActivity {

    public static boolean isRuning = false;
    private static TextView newsim;
    public static Handler refreshNewIMHandler;
    private int i = 0;
    Button btn_nextOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_nextOne = (Button) findViewById(R.id.btn_nextOne);
        btn_nextOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, ForthActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        BaseActivity.currentClass = ThirdActivity.class;
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

package com.example.myservicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myservicetest.ActivityModule.SecondActivity;
import com.example.myservicetest.Service.SendMessageService;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ProtocolDB.initDB(MainActivity.this);

        startBtn = (Button) findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}

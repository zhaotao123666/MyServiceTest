package com.example.myservicetest.ActivityModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myservicetest.R;

public class ForthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseActivity.currentClass = ForthActivity.class;
    }
}

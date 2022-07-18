package com.example.mvptest.mvp.v6.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvptest.R;

/**
 * @author pk
 * @description
 * @date 7/18/22 3:23 PM
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /**
         * 开启一个fragment
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.second_container, new SecondFragment()).commit();
    }
}

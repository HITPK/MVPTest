package com.example.mvptest.mvp.v1.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvptest.R;
import com.example.mvptest.mvp.v1.MainContract;
import com.example.mvptest.mvp.v1.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.IMainView{

    private TextView tv;

    private MainPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Log.d("mvptest", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>onCreate:");

        mPresenter = new MainPresenter(this);
        mPresenter.handlerData();
    }

    private void initViews() {
        tv = findViewById(R.id.tv);
    }


    @Override
    public void showDialog() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    @Override
    public void success(final String content) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }
}

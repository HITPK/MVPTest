package com.example.mvptest.mvp.v2.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvptest.R;
import com.example.mvptest.mvp.v2.presenter.MainPresenter;
import com.example.mvptest.mvp.v2.MainContract;
import com.example.mvptest.mvp.v2.basemvp.BaseActivity;

public class MainActivity extends BaseActivity<MainContract.IMainPresenter> implements MainContract.IMainView{

    private TextView tv;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        tv = $(R.id.tv);
    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
    }

    @Override
    protected MainContract.IMainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showDialog() {
        final ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    @Override
    public void succes(final String content) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }
}
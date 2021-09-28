package com.example.mvptest.mvp.v2.basemvp;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView{

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract P setPresenter();

    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);

        /**
         * 实例化和绑定 P 层
         */
        mPresenter = setPresenter();
        mPresenter.attach(this);

        initViews();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 解绑，避免内存泄漏
         */
        mPresenter.detach();
        mPresenter = null;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
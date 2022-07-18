package com.example.mvptest.mvp.v7.basemvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvptest.mvp.v7.InjectPresenter;
import com.example.mvptest.mvp.v7.proxy.ProxyActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pk
 * @description
 * @date 7/18/22 11:37 AM
 */
public abstract class BaseFragment extends Fragment implements IBaseView {

    private ProxyActivity mProxyActivity;

    private View mLayoutView;

    protected abstract @LayoutRes int setLayout();

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    @SuppressWarnings("ConstantConditions")
    protected <T extends View> T $(@IdRes int viewId) {
        return this.getView().findViewById(viewId);
    }

    @SuppressWarnings({"unchecked", "TryWithIdenticalCatches"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);

        mProxyActivity = createProxyActivity();
        mProxyActivity.bindPresenter();

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(savedInstanceState);
        initData();
    }

    @SuppressWarnings("unchecked")
    private ProxyActivity createProxyActivity() {
        if (mProxyActivity == null) {
            return new ProxyActivity(this);
        }
        return mProxyActivity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mProxyActivity.unbindPresenter();
    }


}

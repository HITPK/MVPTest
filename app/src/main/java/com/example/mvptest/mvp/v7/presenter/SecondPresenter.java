package com.example.mvptest.mvp.v7.presenter;

import android.util.Log;

import com.example.mvptest.mvp.v7.SecondContract;
import com.example.mvptest.mvp.v7.basemvp.BasePresenter;
import com.example.mvptest.mvp.v7.model.SecondModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author pk
 * @description
 * @date 7/18/22 3:40 PM
 */
public class SecondPresenter extends BasePresenter<SecondContract.ISecondView, SecondModel> implements SecondContract.ISecondPresenter {

    @Override
    public void handlerData() {
        Log.d("SecondPresenter", "handlerData: ");
        getView().showDialog();

        getModel().requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String content = response.body().string();
                getView().success(content);
            }
        });
    }
}

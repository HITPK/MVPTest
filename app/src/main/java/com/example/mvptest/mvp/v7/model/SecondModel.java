package com.example.mvptest.mvp.v7.model;

import com.example.mvptest.mvp.v7.SecondContract;
import com.example.mvptest.mvp.v7.basemvp.BaseModel;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author pk
 * @description
 * @date 7/18/22 4:04 PM
 */
public class SecondModel extends BaseModel implements SecondContract.ISecondModel{
    @Override
    public void requestBaidu(Callback callback) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://tieba.baidu.com/index.html")
                .build();
        client.newCall(request).enqueue(callback);
    }
}

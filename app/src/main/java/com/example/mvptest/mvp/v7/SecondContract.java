package com.example.mvptest.mvp.v7;

import com.example.mvptest.mvp.v7.basemvp.IBasePresenter;
import com.example.mvptest.mvp.v7.basemvp.IBaseView;

import okhttp3.Callback;

/**
 * @author pk
 * @description
 * @date 7/18/22 3:35 PM
 */
public interface SecondContract {
    interface ISecondModel{
        void requestBaidu(Callback callback);
    }

    interface ISecondView extends IBaseView {
        void showDialog();

        void success(String content);
    }

    interface ISecondPresenter extends IBasePresenter {
        void handlerData();
    }
}

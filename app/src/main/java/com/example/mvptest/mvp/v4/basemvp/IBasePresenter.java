package com.example.mvptest.mvp.v4.basemvp;

public interface IBasePresenter<V extends IBaseView>{
    void attach(V view);

    void detach();
}

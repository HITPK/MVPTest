package com.example.mvptest.mvp.v2.basemvp;

public interface IBasePresenter<V extends IBaseView>{
    void attach(V view);

    void detach();
}

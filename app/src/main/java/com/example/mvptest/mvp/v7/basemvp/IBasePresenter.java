package com.example.mvptest.mvp.v7.basemvp;

public interface IBasePresenter{
    void attach(IBaseView view);

    void detach();
}

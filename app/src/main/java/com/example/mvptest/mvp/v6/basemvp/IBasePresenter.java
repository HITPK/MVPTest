package com.example.mvptest.mvp.v6.basemvp;

public interface IBasePresenter{
    void attach(IBaseView view);

    void detach();
}

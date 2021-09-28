package com.example.mvptest.mvp.v2.basemvp;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V mView;

    @SuppressWarnings("unchecked")
    @Override
    public void attach(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detach() {
        mView = null;
    }

}

package com.example.mvptest.mvp.v7.proxy;

import com.example.mvptest.mvp.v7.basemvp.IBaseView;

/**
 * @author pk
 * @description
 * @date 7/18/22 5:14 PM
 */
public class ProxyFragment <V extends IBaseView> extends ProxyImpl{

    public ProxyFragment(V view) {
        super(view);
    }
}

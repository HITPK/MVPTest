package com.example.mvptest.mvp.v7.proxy;

import com.example.mvptest.mvp.v7.basemvp.IBaseView;

/**
 * @author pk
 * @description
 * @date 7/18/22 5:11 PM
 */
public class ProxyActivity<V extends IBaseView> extends ProxyImpl {
    public ProxyActivity(V view){
        super(view);
    }
}

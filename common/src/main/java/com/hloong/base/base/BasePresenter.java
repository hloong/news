package com.hloong.base.base;

import android.content.Context;

import com.hloong.base.rx.RxManager;

/**
 * Created by Administrator on 2016/10/7.
 */

public abstract class BasePresenter<T,E> {
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();
    public void setVM(T v,E m){
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){

    }
    public void onDestroy(){
        mRxManage.clear();
    }
}

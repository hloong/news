package com.hloong.base.base;

/**
 * Created by Administrator on 2016/10/7.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view );
    void detachView();
}

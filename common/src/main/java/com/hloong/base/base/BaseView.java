package com.hloong.base.base;

/**
 * Created by Administrator on 2016/10/7.
 *
 * interface for mvp view in all of the project
 */

public interface BaseView {
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
//    void close();
//    void showProgress(String msg, int progress);
}

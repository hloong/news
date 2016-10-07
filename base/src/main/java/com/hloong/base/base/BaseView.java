package com.hloong.base.base;

/**
 * Created by Administrator on 2016/10/7.
 *
 * interface for mvp view in all of the project
 */

public interface BaseView {
    void showMessage(String msg);

    void close();

    void showProgress(String msg);

    void showProgress(String msg, int progress);

    void hideProgress();

    void showErrorMessage(String msg,String content);
}

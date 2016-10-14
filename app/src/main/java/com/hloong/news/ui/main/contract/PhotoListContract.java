package com.hloong.news.ui.main.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.PhotoGirl;

import java.util.List;

import rx.Observable;

/**
 * des:
 * Created by xsf
 * on 2016.09.11:53
 */
public interface PhotoListContract {

    interface Model extends BaseModel {
        Observable< List<PhotoGirl> > getPhotoListData(int size, int page);
    }

    interface View extends BaseView {
        void returnPhotoListData(List<PhotoGirl> photoGirls);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void photoListDataRequest(int size,int page);
    }
}

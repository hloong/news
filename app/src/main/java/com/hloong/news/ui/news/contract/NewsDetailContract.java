package com.hloong.news.ui.news.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.NewsDetail;

import rx.Observable;


/**
 * Created by Administrator on 2016/10/16.
 */

public interface NewsDetailContract {
    interface Model extends BaseModel{
        Observable<NewsDetail> getNewsDetailData(String postId);
    }
    interface View extends BaseView{
        void returnNewsDetailData(NewsDetail newsDetail);
    }

    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getNewsDetailDataRequest(String postId);
    }

}

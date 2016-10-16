package com.hloong.news.ui.news.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.VideoData;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/15.
 */

public interface VideosListContract {
    interface Model extends BaseModel{
        Observable<List<VideoData>> getVideoListData(String type, int startPage);
    }

    interface View extends BaseView{
        void returnVideoListData(List<VideoData> newsVideo);
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getVideoListDataRequest(String type,int startPage);
    }
}

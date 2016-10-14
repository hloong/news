package com.hloong.news.ui.main.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.NewsChannelTable;

import java.util.List;

import rx.Observable;

/**
 * des:
 * Created by xsf
 * on 2016.09.11:53
 */
public interface NewsMainContract {

    interface Model extends BaseModel {
        Observable< List<NewsChannelTable> > NewsChannels();
    }

    interface View extends BaseView {
        void returnNewsChannels(List<NewsChannelTable> newsChannels);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void newsChannelsRequest();
    }
}

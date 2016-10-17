package com.hloong.news.ui.news.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.NewsChannelTable;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by hloong on 2016/10/17.
 */

public interface NewsChannelContract {
    interface Model extends BaseModel{
        Observable<List<NewsChannelTable>> loadNewsChannels();
        Observable<List<NewsChannelTable>> loadMoreNewsChannels();
        Observable<String> swapDB(ArrayList<NewsChannelTable> newsChannelTables,int from,int to);
        Observable<String> updateDB(ArrayList<NewsChannelTable> mineChannelTables,ArrayList<NewsChannelTable> moreChannelTables);
    }
    interface View extends BaseView{
        void returnNewsChannels(List<NewsChannelTable> newsChannels);
        void returnMoreNewsChannels(List<NewsChannelTable> newsMoreChannels);
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void loadChannelRequest();
        public abstract void onItemSwap(ArrayList<NewsChannelTable> newsChannelTables,int from,final int to);
        public abstract void onItemAddOrRemove(ArrayList<NewsChannelTable> mineChannelTables,ArrayList<NewsChannelTable> moreChannelTables);
    }
}

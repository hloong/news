package com.hloong.news.ui.main.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.base.utils.ACache;
import com.hloong.news.app.App;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.db.NewsChannelTableManager;
import com.hloong.news.ui.main.contract.NewsContract;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * des:
 * Created by xsf
 * on 2016.09.17:05
 */
public class NewsModel implements NewsContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> NewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>(){
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTablesList =
                        (ArrayList<NewsChannelTable>)ACache.get(App.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
                if (newsChannelTablesList == null){
                    newsChannelTablesList = (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsStatic();
                    ACache.get(App.getAppContext()).put(AppConstant.CHANNEL_MINE,newsChannelTablesList);
                }
                subscriber.onNext(newsChannelTablesList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }
}

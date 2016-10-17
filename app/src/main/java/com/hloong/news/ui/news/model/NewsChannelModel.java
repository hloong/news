package com.hloong.news.ui.news.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.base.utils.ACache;
import com.hloong.news.R;
import com.hloong.news.api.ApiConstants;
import com.hloong.news.app.App;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.db.NewsChannelTableManager;
import com.hloong.news.ui.news.contract.NewsChannelContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by hloong on 2016/10/17.
 */

public class NewsChannelModel implements NewsChannelContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> loadNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>(){
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTables = (ArrayList<NewsChannelTable>)
                        ACache.get(App.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
                if (newsChannelTables == null){
                    newsChannelTables = (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsStatic();
                }
                subscriber.onNext(newsChannelTables);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<List<NewsChannelTable>> loadMoreNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>(){
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTables = (ArrayList<NewsChannelTable>)
                        ACache.get(App.getAppContext()).getAsObject(AppConstant.CHANNEL_MORE);
                if (newsChannelTables == null){
                    List<String> channelName = Arrays.asList(App.getAppResources().getStringArray(R.array.news_channel_name));
                    List<String> channelId = Arrays.asList(App.getAppResources().getStringArray(R.array.news_channel_id));
                    newsChannelTables = new ArrayList<NewsChannelTable>();
                    for (int i = 0; i < channelName.size(); i++) {
                        NewsChannelTable entity = new NewsChannelTable(channelName.get(i),channelId.get(i)
                        , ApiConstants.getType(channelId.get(i)),i<=5,i,false);
                        newsChannelTables.add(entity);
                    }
                }
                subscriber.onNext(newsChannelTables);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<String> swapDB(final ArrayList<NewsChannelTable> newsChannelTables, int from, int to) {
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(App.getAppContext()).put(AppConstant.CHANNEL_MINE,newsChannelTables);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());
    }

    @Override
    public Observable<String> updateDB(final ArrayList<NewsChannelTable> mineChannelTables, final ArrayList<NewsChannelTable> moreChannelTables) {
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(App.getAppContext()).put(AppConstant.CHANNEL_MINE,mineChannelTables);
                ACache.get(App.getAppContext()).put(AppConstant.CHANNEL_MORE,moreChannelTables);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());
    }
}

package com.hloong.news.ui.news.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.ui.news.contract.NewsChannelContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hloong on 2016/10/17.
 */

public class NewsChannelPresenter extends NewsChannelContract.Presenter {

    @Override
    public void loadChannelRequest() {
        mRxManage.add(mModel.loadNewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(mContext,false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
        mRxManage.add(mModel.loadMoreNewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(mContext,false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnMoreNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }

    @Override
    public void onItemSwap(final ArrayList<NewsChannelTable> newsChannelTables, int from, int to) {
       mRxManage.add(mModel.swapDB(newsChannelTables,from,to).subscribe(new RxSubscriber<String>(mContext,false) {
           @Override
           protected void _onNext(String s) {
               mRxManage.post(AppConstant.NEWS_CHANNEL_CHANGED,newsChannelTables);
           }

           @Override
           protected void _onError(String message) {

           }
       }));
    }

    @Override
    public void onItemAddOrRemove(final ArrayList<NewsChannelTable> mineChannelTables, ArrayList<NewsChannelTable> moreChannelTables) {
        mRxManage.add(mModel.updateDB(mineChannelTables,moreChannelTables).subscribe(new RxSubscriber<String>(mContext,false) {
            @Override
            protected void _onNext(String s) {
                mRxManage.post(AppConstant.NEWS_CHANNEL_CHANGED,mineChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}

package com.hloong.news.ui.main.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.ui.main.contract.NewsMainContract;

import java.util.List;

import rx.functions.Action1;

/**
 * des:
 * Created by xsf
 * on 2016.09.17:43
 */
public class NewsMainPresenter extends NewsMainContract.Presenter{

    @Override
    public void onStart() {
        super.onStart();
        mRxManage.on(AppConstant.NEWS_CHANNEL_CHANGED, new Action1<List<NewsChannelTable>>() {
            @Override
            public void call(List<NewsChannelTable> newsChannelTables) {
                if (newsChannelTables != null){
                    mView.returnNewsChannels(newsChannelTables);
                }
            }
        });

    }


    @Override
    public void newsChannelsRequest() {
        mRxManage.add(mModel.NewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(mContext,false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }

}

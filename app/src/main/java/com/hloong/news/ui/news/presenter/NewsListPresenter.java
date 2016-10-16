package com.hloong.news.ui.news.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsSummary;
import com.hloong.news.ui.news.contract.NewsListContract;

import java.util.List;
import java.util.Observable;

import rx.functions.Action1;

/**
 * Created by Administrator on 2016/10/15.
 */

public class NewsListPresenter extends NewsListContract.Presenter {

    @Override
    public void onStart() {
        super.onStart();
        mRxManage.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scorlltoTop();
            }
        });
    }

    @Override
    public void getNewsListDataRequest(String type, String id, int startPage) {
        mRxManage.add(mModel.getNewsListData(type,id,startPage).subscribe(new RxSubscriber<List<NewsSummary>>(mContext,false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("请稍后...");
            }

            @Override
            protected void _onNext(List<NewsSummary> newsSummaries) {
                mView.returnNewsListData(newsSummaries);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}

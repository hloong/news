package com.hloong.news.ui.news.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.bean.NewsDetail;
import com.hloong.news.ui.news.contract.NewsDetailContract;

/**
 * Created by Administrator on 2016/10/16.
 */

public class NewsDetailPresenter extends NewsDetailContract.Presenter{
    @Override
    public void getNewsDetailDataRequest(String postId) {
        mRxManage.add(mModel.getNewsDetailData(postId).subscribe(new RxSubscriber<NewsDetail>(mContext) {
            @Override
            protected void _onNext(NewsDetail newsDetail) {
                mView.returnNewsDetailData(newsDetail);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}

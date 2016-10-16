package com.hloong.news.ui.news.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.VideoData;
import com.hloong.news.ui.news.contract.VideosListContract;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Administrator on 2016/10/15.
 */

public class VideosListPresenter extends VideosListContract.Presenter {
    @Override
    public void onStart() {
        super.onStart();
        //监听返回顶部动作
        mRxManage.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scrolltoTop();
            }
        });
    }

    @Override
    public void getVideoListDataRequest(String type, int startPage) {
        mRxManage.add(mModel.getVideoListData(type,startPage).subscribe(new RxSubscriber<List<VideoData>>(mContext,false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("请稍后...");
            }

            @Override
            protected void _onNext(List<VideoData> videoDatas) {
                mView.returnVideoListData(videoDatas);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}

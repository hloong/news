package com.hloong.news.ui.news.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.bean.PhotoGirl;
import com.hloong.news.ui.main.contract.PhotoListContract;

import java.util.List;

/**
 * Created by hloong on 2016/10/14.
 */

public class PhotoListPresenter extends PhotoListContract.Presenter{
    @Override
    public void photoListDataRequest(int size, int page) {
        mRxManage.add(mModel.getPhotoListData(size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(mContext,false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("请稍后...");
            }

            @Override
            protected void _onNext(List<PhotoGirl> photoGirls) {
                mView.returnPhotoListData(photoGirls);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}

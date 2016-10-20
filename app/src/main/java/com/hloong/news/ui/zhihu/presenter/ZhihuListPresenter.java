package com.hloong.news.ui.zhihu.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;
import com.hloong.news.ui.zhihu.contract.ZhihuListContract;

/**
 * Created by hloong on 2016/10/19.
 */

public class ZhihuListPresenter extends ZhihuListContract.presenter {
    @Override
    public void getListDataRequest(final String date) {

        mRxManage.add(mModel.getListData(date).subscribe(new RxSubscriber<ZhihuBeforeNews>(mContext) {
            @Override
            protected void _onNext(ZhihuBeforeNews zhihuBeforeNews) {
                mView.returnMoreData(date,zhihuBeforeNews);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void getTopDataRequest() {

        mRxManage.add(mModel.getTopData().subscribe(new RxSubscriber<ZhihuLastsNews>(mContext) {
            @Override
            protected void _onNext(ZhihuLastsNews zhihuLastsNews) {
                mView.returnTopData(zhihuLastsNews);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}

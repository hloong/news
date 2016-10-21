package com.hloong.news.ui.zhihu.presenter;

import com.hloong.base.rx.RxSubscriber;
import com.hloong.news.bean.ZhihuNewsDetail;
import com.hloong.news.ui.zhihu.contract.ZhihuDetailContract;

/**
 * Created by hloong on 2016/10/20.
 */

public class ZhihuDetailPresenter extends ZhihuDetailContract.Presenter {
    @Override
    public void getZhihuDetailRequest(final int id) {
        mRxManage.add(mModel.getZhihuDetail(id).subscribe(new RxSubscriber<ZhihuNewsDetail>(mContext) {
            @Override
            protected void _onNext(ZhihuNewsDetail detail) {
                mView.returnZhihuDetail(id,detail);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}

package com.hloong.news.ui.zhihu.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.news.api.Api;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.ZhihuNewsDetail;
import com.hloong.news.ui.zhihu.contract.ZhihuDetailContract;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hloong on 2016/10/19.
 */

public class ZhihuDetailModel implements ZhihuDetailContract.Model {
    @Override
    public Observable<ZhihuNewsDetail> getZhihuDetail(int id) {
        return Api.getDefault(HostType.ZHIHU_DAILY).getZhihuDetail(Api.getCacheControl(),id)
                .map(new Func1<ZhihuNewsDetail, ZhihuNewsDetail>() {
                    @Override
                    public ZhihuNewsDetail call(ZhihuNewsDetail detail) {
                        return detail;
                    }
                }).compose(RxSchedulers.<ZhihuNewsDetail>io_main());
    }
}

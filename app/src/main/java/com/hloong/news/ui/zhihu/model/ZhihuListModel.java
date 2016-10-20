package com.hloong.news.ui.zhihu.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.news.api.Api;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;
import com.hloong.news.ui.zhihu.contract.ZhihuListContract;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hloong on 2016/10/19.
 */

public class ZhihuListModel implements ZhihuListContract.Model {
    @Override
    public Observable<ZhihuLastsNews> getTopData() {
        return Api.getDefault(HostType.ZHIHU_DAILY).getZhihuTopList(Api.getCacheControl())
                .map(new Func1<ZhihuLastsNews, ZhihuLastsNews>() {
                    @Override
                    public ZhihuLastsNews call(ZhihuLastsNews zhihuLastsNews) {
                        return zhihuLastsNews;
                    }
                }).compose(RxSchedulers.<ZhihuLastsNews>io_main());
    }

    @Override
    public Observable<ZhihuBeforeNews> getListData(String date) {
        return Api.getDefault(HostType.ZHIHU_DAILY).getZhihuList(Api.getCacheControl(),date)
                .map(new Func1<ZhihuBeforeNews, ZhihuBeforeNews>() {
                    @Override
                    public ZhihuBeforeNews call(ZhihuBeforeNews zhihuBeforeNews) {
                        return zhihuBeforeNews;
                    }
                }).compose(RxSchedulers.<ZhihuBeforeNews>io_main());
    }
}

package com.hloong.news.ui.zhihu.model;

import com.hloong.news.bean.ZhihuNewsDetail;
import com.hloong.news.ui.zhihu.contract.ZhihuDetailContract;

import rx.Observable;

/**
 * Created by hloong on 2016/10/19.
 */

public class ZhihuDetailModel implements ZhihuDetailContract.Model {
    @Override
    public Observable<ZhihuNewsDetail> getZhihuDetail(String id) {
        return null;
    }
}

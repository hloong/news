package com.hloong.news.ui.news.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.news.api.Api;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.GirlData;
import com.hloong.news.bean.PhotoGirl;
import com.hloong.news.ui.main.contract.PhotoListContract;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hloong on 2016/10/14.
 */

public class PhotoListModel implements PhotoListContract.Model {
    @Override
    public Observable<List<PhotoGirl>> getPhotoListData(int size, int page) {
        return Api.getDefault(HostType.GANK_GIRL_PHOTO)
                .getPhotoList(Api.getCacheControl(),size,page)
                .map(new Func1<GirlData, List<PhotoGirl>>() {
                    @Override
                    public List<PhotoGirl> call(GirlData girlData) {
                        return girlData.getResults();
                    }
                })
                .compose(RxSchedulers.<List<PhotoGirl>>io_main());
    }
}

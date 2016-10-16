package com.hloong.news.ui.news.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.base.utils.TimeUtil;
import com.hloong.news.api.Api;
import com.hloong.news.api.ApiConstants;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.NewsSummary;
import com.hloong.news.ui.news.contract.NewsListContract;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by Administrator on 2016/10/15.
 */

public class NewsListModel implements NewsListContract.Model {
    @Override
    public Observable<List<NewsSummary>> getNewsListData(final String type, final String id, int startPage) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewsList(Api.getCacheControl(),type,id,startPage)
                .flatMap(new Func1<Map<String, List<NewsSummary>>, Observable<NewsSummary>>() {
                    @Override
                    public Observable<NewsSummary> call(Map<String, List<NewsSummary>> stringListMap) {
                        if (id.endsWith(ApiConstants.HOUSE_ID)){
                            return Observable.from(stringListMap.get("北京"));
                        }
                        return Observable.from(stringListMap.get(id));
                    }
                })
                .map(new Func1<NewsSummary, NewsSummary>() {
                    @Override
                    public NewsSummary call(NewsSummary newsSummary) {
                        String pTime = TimeUtil.formatDate(newsSummary.getPtime());
                        newsSummary.setPtime(pTime);
                        return newsSummary;
                    }
                }).distinct()
                .toSortedList(new Func2<NewsSummary, NewsSummary, Integer>() {
                    @Override
                    public Integer call(NewsSummary newsSummary, NewsSummary newsSummary2) {
                        return newsSummary2.getPtime().compareTo(newsSummary.getPtime());
                    }
                }).compose(RxSchedulers.<List<NewsSummary>>io_main());
    }
}

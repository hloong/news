package com.hloong.news.ui.news.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.base.utils.TimeUtil;
import com.hloong.news.api.Api;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.VideoData;
import com.hloong.news.ui.news.contract.VideosListContract;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by Administrator on 2016/10/15.
 */

public class VideosListModel implements VideosListContract.Model {
    @Override
    public Observable<List<VideoData>> getVideoListData(final String type, int startPage) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getVideoList(Api.getCacheControl(),type,startPage)
                .flatMap(new Func1<Map<String, List<VideoData>>, Observable<VideoData>>() {
                    @Override
                    public Observable<VideoData> call(Map<String, List<VideoData>> stringListMap) {
                        return Observable.from(stringListMap.get(type));
                    }
                }).map(new Func1<VideoData, VideoData>() {
                    @Override
                    public VideoData call(VideoData videoData) {
                        String pTime = TimeUtil.formatDate(videoData.getPtime());
                        videoData.setPtime(pTime);
                        return videoData;
                    }
                }).distinct()//去重
                .toSortedList(new Func2<VideoData, VideoData, Integer>() {
                    @Override
                    public Integer call(VideoData videoData, VideoData videoData2) {
                        return videoData2.getPtime().compareTo(videoData.getPtime());
                    }
                }).compose(RxSchedulers.<List<VideoData>>io_main());  //声明线程调度
    }
}

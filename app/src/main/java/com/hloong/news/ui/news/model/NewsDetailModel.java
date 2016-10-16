package com.hloong.news.ui.news.model;

import com.hloong.base.rx.RxSchedulers;
import com.hloong.news.api.Api;
import com.hloong.news.api.HostType;
import com.hloong.news.bean.NewsDetail;
import com.hloong.news.ui.news.contract.NewsDetailContract;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by Administrator on 2016/10/16.
 */

public class NewsDetailModel implements NewsDetailContract.Model{
    @Override
    public Observable<NewsDetail> getNewsDetailData(final String postId) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewDetail(Api.getCacheControl(),postId)
                .map(new Func1<Map<String, NewsDetail>, NewsDetail>() {
                    @Override
                    public NewsDetail call(Map<String, NewsDetail> stringNewsDetailMap) {
                        NewsDetail newsDetail= stringNewsDetailMap.get(postId);
                        changeNewsDetail(newsDetail);
                        return newsDetail;
                    }
                })
                .compose(RxSchedulers.<NewsDetail>io_main());
    }

    private void changeNewsDetail(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getBody();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setBody(newsBody);
        }
    }

    private boolean isChange(List<NewsDetail.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetail.ImgBean> imgSrcs, String newsBody) {
        for (int i = 0; i < imgSrcs.size(); i++) {
            String oldChars = "<!--IMG#" + i + "-->";
            String newChars;
            if (i == 0) {
                newChars = "";
            } else {
                newChars = "<img src=\"" + imgSrcs.get(i).getSrc() + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}

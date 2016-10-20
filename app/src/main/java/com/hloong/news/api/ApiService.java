package com.hloong.news.api;


import com.hloong.base.base.BaseRespose;
import com.hloong.news.bean.GirlData;
import com.hloong.news.bean.NewsDetail;
import com.hloong.news.bean.NewsSummary;
import com.hloong.news.bean.User;
import com.hloong.news.bean.VideoData;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;
import com.hloong.news.bean.ZhihuNewsDetail;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {

    @GET("login")
    Observable<BaseRespose<User>> login(@Query("username") String username, @Query("password") String password);

    @GET("nc/article/{postId}/full.html")
    Observable<Map<String, NewsDetail>> getNewDetail(
            @Header("Cache-Control") String cacheControl,
            @Path("postId") String postId);

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsSummary>>> getNewsList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type, @Path("id") String id,
            @Path("startPage") int startPage);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Header("Cache-Control") String cacheControl,
            @Url String photoPath);
    //@Url，它允许我们直接传入一个请求的URL。这样以来我们可以将上一个请求的获得的url直接传入进来，baseUrl将被无视
    // baseUrl 需要符合标准，为空、""、或不合法将会报错

    @GET("data/福利/{size}/{page}")
    Observable<GirlData> getPhotoList(
            @Header("Cache-Control") String cacheControl,
            @Path("size") int size,
            @Path("page") int page);

    @GET("nc/video/list/{type}/n/{startPage}-10.html")
    Observable<Map<String, List<VideoData>>> getVideoList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type,
            @Path("startPage") int startPage);


    /*知乎日报*/
    //http://news-at.zhihu.com/api/4/news/latest
    @GET("api/4/news/latest")
    Observable<ZhihuLastsNews> getZhihuTopList(
            @Header("Cache-Control") String cacheControl);

    //http://news.at.zhihu.com/api/4/news/before/20160831
    //返回的是20160830的头条。url需延后一天。
    @GET("api/4/news/before/{date}")
    Observable<ZhihuBeforeNews> getZhihuList(
            @Header("Cache-Control") String cacheControl,
            @Path("date") String date);

    //http://news-at.zhihu.com/api/4/news/8725424
    @GET("api/4/news/{id}")
    Observable<ZhihuNewsDetail> getZhihuDetail(
            @Header("Cache-Control") String cacheControl,
            @Path("id") int id);
}

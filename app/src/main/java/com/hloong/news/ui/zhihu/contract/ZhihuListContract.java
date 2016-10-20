package com.hloong.news.ui.zhihu.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.ZhihuBeforeNews;
import com.hloong.news.bean.ZhihuLastsNews;

import rx.Observable;

/**
 * Created by hloong on 2016/10/19.
 */

public interface ZhihuListContract {
    interface Model extends BaseModel{
        Observable<ZhihuLastsNews> getTopData();
        Observable<ZhihuBeforeNews> getListData(String date);
    }
    interface View extends BaseView{
        void scorlltoTop();
        void returnTopData(ZhihuLastsNews zhihuLastsNews);
        void returnMoreData(String date,ZhihuBeforeNews zhihuBeforeNews);
    }
    abstract  class presenter extends BasePresenter<View,Model>{
        public abstract void getListDataRequest(String date);
        public abstract void getTopDataRequest();
    }
}

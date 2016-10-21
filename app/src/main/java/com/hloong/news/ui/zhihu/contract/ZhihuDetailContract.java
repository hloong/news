package com.hloong.news.ui.zhihu.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.ZhihuNewsDetail;

import rx.Observable;

/**
 * Created by hloong on 2016/10/19.
 */

public interface ZhihuDetailContract {
    interface Model extends BaseModel{
        Observable<ZhihuNewsDetail> getZhihuDetail(int id);
    }
    interface View extends BaseView{
        void returnZhihuDetail(int id,ZhihuNewsDetail detail);
    }
    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getZhihuDetailRequest(int id);
    }
}

package com.hloong.news.ui.news.contract;

import com.hloong.base.base.BaseModel;
import com.hloong.base.base.BasePresenter;
import com.hloong.base.base.BaseView;
import com.hloong.news.bean.NewsSummary;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/15.
 */

public interface NewsListContract {
    interface Model extends BaseModel{
        Observable<List<NewsSummary>> getNewsListData(String type,final String id,int startPage);
    }
    interface View extends BaseView{
        void returnNewsListData(List<NewsSummary> newsSummaries);
        void scorlltoTop();
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getNewsListDataRequest( String type,final String id, int startPage);
    }

}

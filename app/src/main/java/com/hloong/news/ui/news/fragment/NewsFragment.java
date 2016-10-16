package com.hloong.news.ui.news.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.hloong.base.base.BaseFragment;
import com.hloong.base.widget.LoadingTip;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsSummary;
import com.hloong.news.ui.news.adapter.NewsListAdapter;
import com.hloong.news.ui.news.contract.NewsListContract;
import com.hloong.news.ui.news.model.NewsListModel;
import com.hloong.news.ui.news.presenter.NewsListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewsListPresenter,NewsListModel> implements NewsListContract.View {
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    private NewsListAdapter newListAdapter;
    private List<NewsSummary> datas = new ArrayList<>();

    private String mNewsId;
    private String mNewsType;
    private int mStartPage=0;

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    private boolean isVisible;

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            mNewsId = getArguments().getString(AppConstant.NEWS_ID);
            mNewsType = getArguments().getString(AppConstant.NEWS_TYPE);
        }
        irc.setLayoutManager(new LinearLayoutManager(getContext()));
        newListAdapter = new NewsListAdapter(getContext(), datas);
        newListAdapter.openLoadAnimation(new ScaleInAnimation());
        irc.setAdapter(newListAdapter);
        irc.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                newListAdapter.getPageBean().setRefresh(true);
                mStartPage = 0;
                //发起请求
                irc.setRefreshing(true);
                mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
            }
        });
        irc.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(View loadMoreView) {
                newListAdapter.getPageBean().setRefresh(false);
                //发起请求
                irc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
                mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
            }
        });
        //数据为空才重新发起请求
        if(newListAdapter.getSize()<=0) {
            mStartPage = 0;
            mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_base;
    }

    @Override
    public void returnNewsListData(List<NewsSummary> newsSummaries) {
        if (newsSummaries != null) {
            mStartPage += 20;
            if (newListAdapter.getPageBean().isRefresh()) {
                irc.setRefreshing(false);
                newListAdapter.replaceAll(newsSummaries);
            } else {
                if (newsSummaries.size() > 0) {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                    newListAdapter.addAll(newsSummaries);
                } else {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                }
            }
        }
    }

    @Override
    public void scorlltoTop() {
        irc.smoothScrollToPosition(0);
    }

    @Override
    public void showLoading(String title) {
        if( newListAdapter.getPageBean().isRefresh()) {
            loadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    @Override
    public void stopLoading() {
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override
    public void showErrorTip(String msg) {
        if( newListAdapter.getPageBean().isRefresh()) {
            loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
            loadedTip.setTips(msg);
            irc.setRefreshing(false);
        }else{
            irc.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
        }
    }
}

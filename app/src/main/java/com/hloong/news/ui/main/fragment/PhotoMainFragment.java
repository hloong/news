package com.hloong.news.ui.main.fragment;


import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.hloong.base.base.BaseFragment;
import com.hloong.base.image.ImageLoader;
import com.hloong.base.widget.LoadingTip;
import com.hloong.base.widget.NormalTitleBar;
import com.hloong.news.R;
import com.hloong.news.bean.PhotoGirl;
import com.hloong.news.ui.main.contract.PhotoListContract;
import com.hloong.news.ui.news.activity.PhotoDetailActivity;
import com.hloong.news.ui.news.model.PhotoListModel;
import com.hloong.news.ui.news.presenter.PhotoListPresenter;

import java.util.List;

import butterknife.Bind;

/**
 */
public class PhotoMainFragment extends BaseFragment<PhotoListPresenter,PhotoListModel> implements PhotoListContract.View {

    @Bind(R.id.ntb)
    NormalTitleBar ntb;
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private CommonRecycleViewAdapter<PhotoGirl> adapter;
    private static int SIZE = 20;
    private int mStartPage = 1;


    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        ntb.setTvLeftVisiable(false);
        ntb.setTitleText("美女图");
        adapter = new CommonRecycleViewAdapter<PhotoGirl>(getContext(),R.layout.item_photo) {
            @Override
            public void convert(ViewHolderHelper helper, final PhotoGirl photoGirl) {
                ImageView imageView = helper.getView(R.id.iv_photo);
                ImageLoader.displayOverride(getContext(),imageView,photoGirl.getUrl());
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoDetailActivity.startAction(mContext,photoGirl.getUrl());
                    }
                });
            }
        };
        irc.setAdapter(adapter);
        irc.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        irc.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(View loadMoreView) {
                adapter.getPageBean().setRefresh(false);
                //发起请求
                irc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
                mPresenter.photoListDataRequest(SIZE, mStartPage);
            }
        });
        irc.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.getPageBean().setRefresh(true);
                mStartPage = 0;
                //发起请求
                irc.setRefreshing(true);
                mPresenter.photoListDataRequest(SIZE, mStartPage);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irc.smoothScrollToPosition(0);
            }
        });
        mPresenter.photoListDataRequest(SIZE,mStartPage);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_photos;
    }

    @Override
    public void returnPhotoListData(List<PhotoGirl> photoGirls) {
        if (photoGirls != null){
            mStartPage += 1;
            if (adapter.getPageBean().isRefresh()){
                irc.setRefreshing(false);
                adapter.replaceAll(photoGirls);
            }else {
                if (photoGirls.size() > 0){
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                    adapter.addAll(photoGirls);
                }else {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                }
            }
        }
    }

    @Override
    public void showLoading(String title) {
        if (adapter.getPageBean().isRefresh()){
           loadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    @Override
    public void stopLoading() {
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override
    public void showErrorTip(String msg) {
        if( adapter.getPageBean().isRefresh()) {
            loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
            loadedTip.setTips(msg);
            irc.setRefreshing(false);
        }else{
            irc.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
        }
    }


}

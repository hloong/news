package com.hloong.news.ui.main.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.hloong.base.base.BaseFragment;
import com.hloong.base.base.BaseFragmentAdapter;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.ui.main.contract.NewsContract;
import com.hloong.news.ui.main.model.NewsModel;
import com.hloong.news.ui.main.presenter.NewsPresenter;

import java.util.List;

import butterknife.Bind;

public class NewsFragment extends BaseFragment<NewsPresenter,NewsModel> implements NewsContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.add_channel_iv)
    ImageView addChannelIv;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;
    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        mPresenter.newsChannelsRequest();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP,"");
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    public void returnNewsChannels(List<NewsChannelTable> newsChannels) {
    }


    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}

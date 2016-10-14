package com.hloong.news.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.hloong.base.base.BaseFragment;
import com.hloong.base.base.BaseFragmentAdapter;
import com.hloong.base.utils.TabLayoutUtil;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.NewsChannelTable;
import com.hloong.news.ui.main.contract.NewsMainContract;
import com.hloong.news.ui.main.model.NewsMainModel;
import com.hloong.news.ui.main.presenter.NewsMainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class NewsMainFragment extends BaseFragment<NewsMainPresenter,NewsMainModel> implements NewsMainContract.View {

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
        if(newsChannels != null){
            List<String> channelNames = new ArrayList<>();
            List<Fragment> mNewsFragmentList = new ArrayList<>();
            for (int i = 0; i < newsChannels.size(); i++) {
                channelNames.add(newsChannels.get(i).getNewsChannelName());
                mNewsFragmentList.add(createListFragments(newsChannels.get(i)));
            }
            fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(),mNewsFragmentList);
            viewPager.setAdapter(fragmentAdapter);
            tabs.setupWithViewPager(viewPager);
            TabLayoutUtil.dynamicSetTabLayoutMode(tabs);
            setPageChangeListener();
        }



    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private NewsMainFragment createListFragments(NewsChannelTable newsChannelTable) {
        NewsMainFragment fragment = new NewsMainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.NEWS_ID,newsChannelTable.getNewsChannelId());
        bundle.putString(AppConstant.NEWS_TYPE,newsChannelTable.getNewsChannelType());
        bundle.putInt(AppConstant.CHANNEL_POSITION,newsChannelTable.getNewsChannelIndex());
        fragment.setArguments(bundle);
        return fragment;
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

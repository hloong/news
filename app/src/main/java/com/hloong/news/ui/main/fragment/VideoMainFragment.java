package com.hloong.news.ui.main.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hloong.base.base.BaseFragment;
import com.hloong.base.base.BaseFragmentAdapter;
import com.hloong.base.utils.TabLayoutUtil;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.VideoChannelTable;
import com.hloong.news.db.VideosChannelTableManager;
import com.hloong.news.ui.news.fragment.VideosFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoMainFragment extends BaseFragment {

    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;
    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        List<String> channelNames = new ArrayList<>();
        List<VideoChannelTable> videoChannelTableList = VideosChannelTableManager.loadVideosChannelsMine();
        List<Fragment> mNewsFragmentList = new ArrayList<>();
        for (int i = 0; i < videoChannelTableList.size(); i++) {
            channelNames.add(videoChannelTableList.get(i).getChannelName());
            mNewsFragmentList.add(createListFragments(videoChannelTableList.get(i)));
        }
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        TabLayoutUtil.dynamicSetTabLayoutMode(tabs);
        setPageChangeListener();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_video_main;
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

    private VideosFragment createListFragments(VideoChannelTable videoChannelTable) {
        VideosFragment fragment = new VideosFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.VIDEO_TYPE, videoChannelTable.getChannelId());
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}

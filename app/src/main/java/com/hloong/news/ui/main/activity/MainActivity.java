package com.hloong.news.ui.main.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hloong.base.base.BaseActivity;
import com.hloong.base.daynight.ChangeModeController;
import com.hloong.base.utils.LogUtil;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.TabEntity;
import com.hloong.news.ui.main.fragment.MoreMainFragment;
import com.hloong.news.ui.main.fragment.NewsMainFragment;
import com.hloong.news.ui.main.fragment.PhotoMainFragment;
import com.hloong.news.ui.main.fragment.VideoMainFragment;

import java.util.ArrayList;

import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {
    @Bind(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"首页", "视频","美女","更多"};
    private int[] mIconUnselectIds = {
            R.drawable.ic_home_normal,
            R.drawable.ic_video_normal,
            R.drawable.ic_girl_normal,
            R.drawable.ic_more_normal};
    private int[] mIconSelectIds = {
            R.drawable.ic_home_selected,
            R.drawable.ic_video_selected,
            R.drawable.ic_girl_selected,
            R.drawable.ic_more_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private NewsMainFragment newsMainFragment;
    private PhotoMainFragment photoMainFragment;
    private VideoMainFragment videoMainFragment;
    private MoreMainFragment moreMainFragment;
    private static int tabLayoutHeight;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.e("onSave 1");
        if (tabLayout != null) {
            LogUtil.e("onSave 2");
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tabLayout.getCurrentTab());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //切换daynight模式要立即变色的页面
        ChangeModeController.getInstance().init(this,R.attr.class);
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        tabLayout.measure(0,0);
        tabLayoutHeight=tabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏
        mRxManager.on(AppConstant.MENU_SHOW_HIDE, new Action1<Boolean>() {

            @Override
            public void call(Boolean hideOrShow) {
                startAnimation(hideOrShow);
            }
        });

    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null){
            newsMainFragment = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment");
            photoMainFragment = (PhotoMainFragment) getSupportFragmentManager().findFragmentByTag("photoMainFragment");
            videoMainFragment = (VideoMainFragment) getSupportFragmentManager().findFragmentByTag("videoMainFragment");
            moreMainFragment = (MoreMainFragment) getSupportFragmentManager().findFragmentByTag("moreMainFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        }else {
            newsMainFragment = new NewsMainFragment();
            photoMainFragment = new PhotoMainFragment();
            videoMainFragment = new VideoMainFragment();
            moreMainFragment = new MoreMainFragment();

            transaction.add(R.id.fl_body, newsMainFragment,"newsMainFragment");
            transaction.add(R.id.fl_body, photoMainFragment,"photoMainFragment");
            transaction.add(R.id.fl_body,videoMainFragment,"videoMainFragment");
            transaction.add(R.id.fl_body,moreMainFragment,"moreMainFragment");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initTab();
    }

    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void SwitchTo(int position) {
        LogUtil.d("主页菜单postion "+position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position){
            case 0://首页
                transaction.hide(photoMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(moreMainFragment);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 1://视频
                transaction.hide(photoMainFragment);
                transaction.hide(newsMainFragment);
                transaction.hide(moreMainFragment);
                transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2://图片
                transaction.hide(videoMainFragment);
                transaction.hide(newsMainFragment);
                transaction.hide(moreMainFragment);
                transaction.show(photoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 3://更多
                transaction.hide(videoMainFragment);
                transaction.hide(newsMainFragment);
                transaction.hide(photoMainFragment);
                transaction.show(moreMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }

    /**
     * 菜单显示隐藏动画
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide){
        final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if(!showOrHide){
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
        }else{
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height= (int) valueAnimator.getAnimatedValue();
                tabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator,alpha);
        animatorSet.start();
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ChangeModeController.onDestory();
    }

    /**
     * 监听返回键，让其回后台而不是finish
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

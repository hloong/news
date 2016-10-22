package com.hloong.news.ui.main.fragment;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hloong.base.base.BaseFragment;
import com.hloong.base.daynight.ChangeModeController;
import com.hloong.base.widget.NormalTitleBar;
import com.hloong.news.R;
import com.hloong.news.ui.zone.activity.CircleZoneActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * des:关注主页
 * Created by xsf
 * on 2016.09.17:07
 */
public class MoreMainFragment extends BaseFragment {
    @Bind(R.id.ll_friend_zone)
    LinearLayout llFriendZone;
    @Bind(R.id.ntb)
    NormalTitleBar ntb;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_care;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        ntb.setTvLeftVisiable(false);
        ntb.setTitleText(getContext().getString(R.string.care_main_title));
    }
    @OnClick(R.id.ll_friend_zone)
    public void friendZone(){
        CircleZoneActivity.startAction(getContext());
    }
    @OnClick(R.id.ll_daynight_toggle)
    public void dayNightToggle(){
        ChangeModeController.toggleThemeSetting(getActivity());
    }
}

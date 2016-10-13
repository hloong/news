package com.hloong.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hloong.base.rx.RxManager;
import com.hloong.base.utils.TUtil;

import butterknife.ButterKnife;

/**
 * Created by hloong on 2016/10/13.
 */

public abstract class BaseFragment<T extends BasePresenter,E extends BaseModel> extends Fragment {
    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null){
            rootView = inflater.inflate(getLayoutResource(),container,false);
        }
        mRxManager = new RxManager();
        ButterKnife.bind(this,rootView);
        mPresenter = TUtil.getT(this,0);
        mModel = TUtil.getT(this,1);
        if (mPresenter != null){
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView();
        return rootView;
    }

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    protected abstract void initPresenter();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getLayoutResource();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null){
            mPresenter.onDestroy();
        }
        mRxManager.clear();
    }
}

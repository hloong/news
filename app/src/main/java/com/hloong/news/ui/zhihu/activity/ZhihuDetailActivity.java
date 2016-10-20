package com.hloong.news.ui.zhihu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hloong.base.base.BaseActivity;
import com.hloong.news.R;
import com.hloong.news.api.ApiConstants;
import com.hloong.news.bean.ZhihuNewsDetail;
import com.hloong.news.ui.zhihu.contract.ZhihuDetailContract;
import com.hloong.news.ui.zhihu.model.ZhihuDetailModel;
import com.hloong.news.ui.zhihu.presenter.ZhihuDetailPresenter;

public class ZhihuDetailActivity extends BaseActivity<ZhihuDetailPresenter,ZhihuDetailModel> implements ZhihuDetailContract.View {


    public static void startAction(Context context,final int id){
        Intent intent = new Intent(context,ZhihuDetailActivity.class);
        intent.putExtra(ApiConstants.ZHIHU_ID,id);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void returnZhihuDetail(String id, ZhihuNewsDetail detail) {

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

package com.hloong.news.ui.zhihu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.hloong.base.base.BaseActivity;
import com.hloong.base.image.ImageLoader;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.bean.ZhihuNewsDetail;
import com.hloong.news.ui.zhihu.contract.ZhihuDetailContract;
import com.hloong.news.ui.zhihu.model.ZhihuDetailModel;
import com.hloong.news.ui.zhihu.presenter.ZhihuDetailPresenter;
import com.hloong.news.widget.URLImageGetter;

import butterknife.Bind;

public class ZhihuDetailActivity extends BaseActivity<ZhihuDetailPresenter,ZhihuDetailModel> implements ZhihuDetailContract.View {

    @Bind(R.id.zhihu_photo_iv)
    ImageView zhihuDetailPhotoIv;
    @Bind(R.id.mask_view)
    View maskView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.zhihu_body_tv)
    WebView zhihuDetailBodyTv;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private int id;
    private String zhihuTitle;
    private String mShareLink;

    public static void startAction(Context context,int id){
        Intent intent = new Intent(context,ZhihuDetailActivity.class);
        intent.putExtra(AppConstant.ZHIHU_ID,id);
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
        SetTranslanteBar();
        id = getIntent().getIntExtra(AppConstant.ZHIHU_ID,0);
        mPresenter.getZhihuDetailRequest(id);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Share();
            }
        });
    }
    private void Share() {
        if (mShareLink == null) {
            mShareLink = "";
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, zhihuTitle, mShareLink));
        startActivity(Intent.createChooser(intent, getTitle()));
    }
    @Override
    public void returnZhihuDetail(int id, ZhihuNewsDetail detail) {
        mShareLink = detail.getShare_url();
        zhihuTitle = detail.getTitle();
        ImageLoader.display(this,zhihuDetailPhotoIv,detail.getImage());
        toolbarLayout.setTitle(zhihuTitle);
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.primary_text_white));
//
        String htmlData = "<link rel=\"stylesheet\" type=\"text/css\" href=\"zhihu.css\" />" +detail.getBody();
        zhihuDetailBodyTv.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "utf-8", null);

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

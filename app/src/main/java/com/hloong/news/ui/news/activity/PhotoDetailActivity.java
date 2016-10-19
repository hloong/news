package com.hloong.news.ui.news.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.hloong.base.base.BaseActivity;
import com.hloong.base.image.ImageLoader;
import com.hloong.base.utils.SystemUiVisibilityUtil;
import com.hloong.base.utils.TabLayoutUtil;
import com.hloong.base.widget.StatusBarCompat;
import com.hloong.news.R;
import com.hloong.news.app.AppConstant;
import com.hloong.news.widget.PullBackLayout;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PhotoDetailActivity extends BaseActivity {
    @Bind(R.id.photo_touch_iv)
    PhotoView photoTouchIv;
    @Bind(R.id.pull_back_layout)
    PullBackLayout pullBackLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.background)
    RelativeLayout background;
    private boolean mIsToolBarHidden;
    private boolean mIsStatusBarHidden;
    private ColorDrawable mBackground;

    public static void startAction(Context context, String url){
        Intent intent = new Intent(context, PhotoDetailActivity.class);
        intent.putExtra(AppConstant.PHOTO_DETAIL,url);
        context.startActivity(intent);
    }

    @Override
    public void setContentViewBefore() {
        StatusBarCompat.translucentStatusBar(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_detail;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        toolBarFadeIn();
        initToolbar();
        initBackground();
        loadPhotoIv();
        setPhotoViewClickEvent();
        pullBackLayout.setCallback(new PullBackLayout.Callback() {
            @Override
            public void onPullStart() {
                toolBarFadeOut();
                mIsStatusBarHidden = true;
                hideOrShowStatusBar();
            }

            @Override
            public void onPull(float progress) {
                progress = Math.min(1f, progress * 3f);
                mBackground.setAlpha((int) (0xff/*255*/ * (1f - progress)));
            }

            @Override
            public void onPullCancel() {
                toolBarFadeIn();
            }

            @Override
            public void onPullComplete() {
                supportFinishAfterTransition();
            }
        });
    }

    @Override
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    private void toolBarFadeOut() {
        mIsToolBarHidden = false;
        hideOrShowToolbar();
    }
    private void initToolbar() {
        toolbar.setTitle(getString(R.string.girl));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadPhotoIv() {
        String url = getIntent().getStringExtra(AppConstant.PHOTO_DETAIL);
        ImageLoader.display(this,photoTouchIv,url);
    }

    private void setPhotoViewClickEvent() {
        photoTouchIv.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float v, float v1) {
                hideOrShowToolbar();
                hideOrShowStatusBar();
            }
        });
    }

    private void initBackground() {
        mBackground = new ColorDrawable(Color.BLACK);
        TabLayoutUtil.getRootView(this).setBackgroundDrawable(mBackground);
    }


    protected void hideOrShowToolbar() {
        toolbar.animate()
                .alpha(mIsToolBarHidden ? 1.0f : 0.0f)
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsToolBarHidden = !mIsToolBarHidden;
    }

    private void hideOrShowStatusBar() {
        if (mIsStatusBarHidden) {
            SystemUiVisibilityUtil.enter(PhotoDetailActivity.this);
        } else {
            SystemUiVisibilityUtil.exit(PhotoDetailActivity.this);
        }
        mIsStatusBarHidden = !mIsStatusBarHidden;
    }

    private void toolBarFadeIn() {
        mIsToolBarHidden = true;
        hideOrShowToolbar();
    }
}

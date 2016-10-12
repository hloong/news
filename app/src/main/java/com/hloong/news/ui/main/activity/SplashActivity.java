package com.hloong.news.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;

import com.hloong.base.base.BaseActivity;
import com.hloong.news.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        SetTranslanteBar();
        //rxjava替代handler
        Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(mIntent);
                        finish();
                    }
                });
    }


}

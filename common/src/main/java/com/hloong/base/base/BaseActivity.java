package com.hloong.base.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mobstat.StatService;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews(savedInstanceState);
        initPresenter();
        loadData();
    }



    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getLayoutId();
    /**
     * 初始化变量
     */
    protected abstract void initPresenter();
    /**
     * 初始化布局
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);
    /**
     * 加载数据
     */
    protected abstract void loadData();
}

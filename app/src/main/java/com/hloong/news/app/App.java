package com.hloong.news.app;

import com.hloong.base.base.BaseApplication;

/**
 * Created by hloong on 2016/10/12.
 */

public class App extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();

        initHXCloud();
    }

    private void initHXCloud() {
//        EMOptions options = new EMOptions();
//        // 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//        EaseUI.getInstance().init(this, options);
    }
}

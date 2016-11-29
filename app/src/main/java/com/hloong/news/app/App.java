package com.hloong.news.app;

import com.easemob.redpacketsdk.RedPacket;
import com.hloong.base.base.BaseApplication;
import com.hloong.news.chat.DemoHelper;

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
        //init demo helper
        DemoHelper.getInstance().init(App.getAppContext());
        //red packet code : 初始化红包上下文，开启日志输出开关
        RedPacket.getInstance().initContext(App.getAppContext());
        RedPacket.getInstance().setDebugMode(true);
    }
}

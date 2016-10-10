package com.hloong.base.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by hloong on 2016/10/10.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

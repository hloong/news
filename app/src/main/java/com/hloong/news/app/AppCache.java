package com.hloong.news.app;

import android.content.Context;

/**
 * Created by hloong on 2016/10/17.
 */

public class AppCache {
    private Context context;//应用实例
    private String token;
    private String userId="10000";
    private String userName="hloong";
    private String icon="";
    public static AppCache instance = new AppCache();


    private AppCache(){
    }

    public static AppCache getInstance() {
        return instance;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

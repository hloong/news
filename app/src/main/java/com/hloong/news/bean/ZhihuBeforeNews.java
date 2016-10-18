package com.hloong.news.bean;

import java.util.List;

/**
 * Created by hloong on 2016/10/18.
 */

public class ZhihuBeforeNews {
    private String date;
    private List<Story> stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public String getDate() {
        return date;
    }

    public List<Story> getStories() {
        return stories;
    }
}

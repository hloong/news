package com.hloong.news.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hloong on 2016/10/18.
 * 知乎日报
 */

public class ZhihuLastsNews implements Serializable{
    private String date;

    private List<Story> stories;

    private List<TopStory> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStory> topStories) {
        this.top_stories = topStories;
    }

    public String getDate() {
        return date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public List<TopStory> getTopStories() {
        return top_stories;
    }
}

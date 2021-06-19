package com.vincent.kotlin1.bean.tuijian;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private String date;

    private List<Stories> stories;

    private List<Top_stories> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }

    public List<Stories> getStories() {
        return this.stories;
    }

    public void setTop_stories(List<Top_stories> top_stories) {
        this.top_stories = top_stories;
    }

    public List<Top_stories> getTop_stories() {
        return this.top_stories;
    }
}

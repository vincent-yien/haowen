package com.vincent.kotlin1.bean.tuijian;

import java.util.ArrayList;

public class News {
    private ArrayList<Stories> news = new ArrayList<>();

    public ArrayList<Stories> getNews() {
        return news;
    }

    public void setNews(ArrayList<Stories> news) {
        this.news = news;
    }

    public void addData(Stories stories){
        news.add(stories);
    }
}

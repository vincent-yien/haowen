package com.vincent.kotlin1.bean.tuijian;

import com.vincent.kotlin1.bean.articleBean.ArticleBaseBean;

import java.util.ArrayList;
import java.util.List;

public class Stories extends ArticleBaseBean {
    private String image_hue;

    private String title;

    private String url;

    private String hint;

    private String ga_prefix;

    private List<String> images;

    private int type;

    private int id;

    public void setImage_hue(String image_hue) {
        this.image_hue = image_hue;
    }

    public String getImage_hue() {
        return this.image_hue;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return this.hint;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getGa_prefix() {
        return this.ga_prefix;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
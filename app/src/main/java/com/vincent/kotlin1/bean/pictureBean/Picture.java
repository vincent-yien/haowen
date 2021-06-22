package com.vincent.kotlin1.bean.pictureBean;

public class Picture {
    private String id;

    private String author;

    private int width;

    private int height;

    private String url;

    private String download_url;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getDownload_url() {
        return this.download_url;
    }
}

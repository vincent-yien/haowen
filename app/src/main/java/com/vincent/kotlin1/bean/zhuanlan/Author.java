package com.vincent.kotlin1.bean.zhuanlan;

import java.util.List;

public class Author {
    private boolean is_followed;

    private String avatar_url_template;

    private String uid;

    private String user_type;

    private boolean is_following;

    private String type;

    private String url_token;

    private String id;

    private String description;

    private String name;

    private boolean is_advertiser;

    private String headline;

    private int gender;

    private String url;

    private String avatar_url;

    private boolean is_org;

    private List<Badge> badge;

    public void setIs_followed(boolean is_followed) {
        this.is_followed = is_followed;
    }

    public boolean getIs_followed() {
        return this.is_followed;
    }

    public void setAvatar_url_template(String avatar_url_template) {
        this.avatar_url_template = avatar_url_template;
    }

    public String getAvatar_url_template() {
        return this.avatar_url_template;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_type() {
        return this.user_type;
    }

    public void setIs_following(boolean is_following) {
        this.is_following = is_following;
    }

    public boolean getIs_following() {
        return this.is_following;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setUrl_token(String url_token) {
        this.url_token = url_token;
    }

    public String getUrl_token() {
        return this.url_token;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIs_advertiser(boolean is_advertiser) {
        this.is_advertiser = is_advertiser;
    }

    public boolean getIs_advertiser() {
        return this.is_advertiser;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return this.headline;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return this.gender;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public void setIs_org(boolean is_org) {
        this.is_org = is_org;
    }

    public boolean getIs_org() {
        return this.is_org;
    }

    public void setBadge(List<Badge> badge) {
        this.badge = badge;
    }

    public List<Badge> getBadge() {
        return this.badge;
    }
}
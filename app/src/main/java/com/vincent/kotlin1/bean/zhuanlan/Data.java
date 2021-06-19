package com.vincent.kotlin1.bean.zhuanlan;

import com.vincent.kotlin1.bean.articleBean.ArticleBaseBean;

public class Data extends ArticleBaseBean {
    private int updated;

    private boolean is_labeled;

    private String copyright_permission;

    private String excerpt;

    private boolean admin_closed_comment;

    private String article_type;

    private String reason;

    private String title_image;

    private String excerpt_title;

    private int id;

    private int voteup_count;

    private int voting;

    private Author author;

    private String url;

    private String comment_permission;

    private boolean has_column;

    private String state;

    private int created;

    private String content;

    private int comment_count;

    private String image_url;

    private String title;

    private Can_comment can_comment;

    private String type;

    private Suggest_edit suggest_edit;

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getUpdated() {
        return this.updated;
    }

    public void setIs_labeled(boolean is_labeled) {
        this.is_labeled = is_labeled;
    }

    public boolean getIs_labeled() {
        return this.is_labeled;
    }

    public void setCopyright_permission(String copyright_permission) {
        this.copyright_permission = copyright_permission;
    }

    public String getCopyright_permission() {
        return this.copyright_permission;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getExcerpt() {
        return this.excerpt;
    }

    public void setAdmin_closed_comment(boolean admin_closed_comment) {
        this.admin_closed_comment = admin_closed_comment;
    }

    public boolean getAdmin_closed_comment() {
        return this.admin_closed_comment;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getArticle_type() {
        return this.article_type;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setTitle_image(String title_image) {
        this.title_image = title_image;
    }

    public String getTitle_image() {
        return this.title_image;
    }

    public void setExcerpt_title(String excerpt_title) {
        this.excerpt_title = excerpt_title;
    }

    public String getExcerpt_title() {
        return this.excerpt_title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setVoteup_count(int voteup_count) {
        this.voteup_count = voteup_count;
    }

    public int getVoteup_count() {
        return this.voteup_count;
    }

    public void setVoting(int voting) {
        this.voting = voting;
    }

    public int getVoting() {
        return this.voting;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setComment_permission(String comment_permission) {
        this.comment_permission = comment_permission;
    }

    public String getComment_permission() {
        return this.comment_permission;
    }

    public void setHas_column(boolean has_column) {
        this.has_column = has_column;
    }

    public boolean getHas_column() {
        return this.has_column;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getCreated() {
        return this.created;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getComment_count() {
        return this.comment_count;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCan_comment(Can_comment can_comment) {
        this.can_comment = can_comment;
    }

    public Can_comment getCan_comment() {
        return this.can_comment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setSuggest_edit(Suggest_edit suggest_edit) {
        this.suggest_edit = suggest_edit;
    }

    public Suggest_edit getSuggest_edit() {
        return this.suggest_edit;
    }

    @Override
    public String toString() {
        return "Data{" +
                "updated=" + updated +
                ", is_labeled=" + is_labeled +
                ", copyright_permission='" + copyright_permission + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", admin_closed_comment=" + admin_closed_comment +
                ", article_type='" + article_type + '\'' +
                ", reason='" + reason + '\'' +
                ", title_image='" + title_image + '\'' +
                ", excerpt_title='" + excerpt_title + '\'' +
                ", id=" + id +
                ", voteup_count=" + voteup_count +
                ", voting=" + voting +
                ", author=" + author +
                ", url='" + url + '\'' +
                ", comment_permission='" + comment_permission + '\'' +
                ", has_column=" + has_column +
                ", state='" + state + '\'' +
                ", created=" + created +
                ", content='" + content + '\'' +
                ", comment_count=" + comment_count +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                ", can_comment=" + can_comment +
                ", type='" + type + '\'' +
                ", suggest_edit=" + suggest_edit +
                '}';
    }
}
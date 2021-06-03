package com.vincent.kotlin1.bean;

import java.util.List;

public class Badge
{
    private List<String> topics;

    private String type;

    private String description;

    public void setTopics(List<String> topics){
        this.topics = topics;
    }
    public List<String> getTopics(){
        return this.topics;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}
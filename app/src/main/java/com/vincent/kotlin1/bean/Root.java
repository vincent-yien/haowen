package com.vincent.kotlin1.bean;

import java.util.List;

public class Root
{
    private Paging paging;

    private List<Data> data;

    public void setPaging(Paging paging){
        this.paging = paging;
    }
    public Paging getPaging(){
        return this.paging;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
}

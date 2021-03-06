package com.teste.star_wars_app.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDTO<T> implements Serializable {

    private int count;

    private  String next;

    private String previous;

    private List<T> results = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public boolean hasNext(){
        return this.next != null && !this.next.isEmpty();
    }
}

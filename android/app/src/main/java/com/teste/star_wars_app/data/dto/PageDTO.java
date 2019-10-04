package com.teste.star_wars_app.data.dto;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO<T> implements Serializable {

    private int count;

    private  String next;

    private String previous;

    private ArrayList<T> results;

    public boolean hasMore() {
        return !TextUtils.isEmpty(next);
    }
}

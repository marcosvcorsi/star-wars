package com.teste.star_wars_app.data.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO<T> implements Serializable {

    private int count;

    private  String next;

    private String previous;

    private List<T> results;

}

package com.imeverao.springboot.model;

public class MemeRequest {
    private String name;
    private String[] keywords;
    private String media;

    public String getName() {
        return name;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getMedia() {
        return media;
    }

    public MemeRequest(String name, String[] keywords, String media) {
        this.name = name;
        this.keywords = keywords;
        this.media = media;
    }
}

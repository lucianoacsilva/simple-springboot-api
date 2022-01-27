package com.imeverao.springboot.model;

public class Meme {

    private Long Id;
    private String name;
    private String[] keywords;
    private String media;

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getMedia() {
        return media;
    }

    public Meme(Long id, String name, String[] keywords, String media) {
        Id = id;
        this.name = name;
        this.keywords = keywords;
        this.media = media;
    }
}

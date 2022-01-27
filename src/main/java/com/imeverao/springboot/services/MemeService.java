package com.imeverao.springboot.services;

import com.imeverao.springboot.model.Meme;
import com.imeverao.springboot.model.MemeRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MemeService {
    private ArrayList<Meme> memesArray = new ArrayList<Meme>();

    public Meme create(MemeRequest memeReq) {
        Random rand = new Random();
        Meme meme = new Meme(rand.nextLong(), memeReq.getName(), memeReq.getKeywords(), memeReq.getMedia());
        memesArray.add(meme);

        return meme;
    }

    public ArrayList<Meme> readAll() {
        return this.memesArray;
    }

    public Meme read(Long memeId) {

        return (Meme) this.justRead(memeId).get("meme");
    }

    public Meme update(Long memeId, MemeRequest memeData) {
        HashMap<String, Object> memeRead = this.justRead(memeId);

        int memeIndex = (int) memeRead.get("index");
        Meme currentMeme = (Meme) memeRead.get("meme");
        Meme newMeme = new Meme(currentMeme.getId(), memeData.getName(), memeData.getKeywords(), memeData.getMedia());
        this.memesArray.set(memeIndex, newMeme);

        return newMeme;

    }

    public Meme delete(Long memeId) {
        HashMap<String, Object> meme = this.justRead(memeId);
        int index = (int) meme.get("index");
        this.memesArray.remove(index);

        return (Meme) meme.get("meme");

    }

    private HashMap<String, Object> justRead(Long memeId) {
        HashMap<String, Object> response = new HashMap<>();

        Meme meme = this.memesArray.stream().filter(meme1 -> meme1.getId().toString().equals(memeId.toString()))
                .findFirst().orElse(null);
        int memeIndex = this.memesArray.indexOf(meme);

        response.put("meme", meme);
        response.put("index", memeIndex);

        return response;
    }
}

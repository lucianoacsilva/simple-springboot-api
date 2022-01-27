package com.imeverao.springboot.controller;
import com.imeverao.springboot.model.Meme;
import com.imeverao.springboot.model.MemeRequest;
import com.imeverao.springboot.services.MemeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.stream.Stream;

@RestController
public class MemeController {

    private MemeService memeService = new MemeService();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/memes")
    public Stream<HashMap<String, Object>> readAllMemes() {
        return this.memeService.readAll().stream().map(meme -> this.responseMapper(meme));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/memes/{id}")
    public HashMap<String, Object> readMeme(@PathVariable("id") Long id) {
        return this.responseMapper(this.memeService.read(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/memes")
    public HashMap<String, Object> createMeme(@RequestBody MemeRequest memeRequest) {
        return this.responseMapper(this.memeService.create(memeRequest));

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/memes/{id}")
    public HashMap<String, Object> updateMeme(@PathVariable("id") Long id, @RequestBody MemeRequest memeRequest) {
        return this.responseMapper(this.memeService.update(id, memeRequest));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/memes/{id}")
    public HashMap<String, Object> deleteMeme(@PathVariable("id") Long id) {
        return this.responseMapper(this.memeService.delete(id));
    }

    private HashMap<String, Object> responseMapper (Meme meme) {
        HashMap<String, Object> responseMap = new HashMap<>();

        responseMap.put("id", meme.getId());
        responseMap.put("name", meme.getName());
        responseMap.put("keywords", meme.getKeywords());
        responseMap.put("media", meme.getMedia());

        return responseMap;
    }
}

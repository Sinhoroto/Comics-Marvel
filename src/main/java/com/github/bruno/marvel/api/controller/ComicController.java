package com.github.bruno.marvel.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.bruno.marvel.api.MarvelAPI;
import com.github.bruno.marvel.domain.model.Comic;

@RestController
public class ComicController {

    @Autowired
    private MarvelAPI marvelApi;

    @GetMapping(value = "/comic")
	public Comic buscar(){
		return marvelApi.getComicById(1308);
	}
}
package com.github.bruno.marvel.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.bruno.marvel.domain.entity.ComicEntity;
import com.github.bruno.marvel.domain.service.ComicService;

@RestController
public class ComicController {

	@Autowired
	private ComicService comicService;
	
	@PostMapping("comics/{comicId}/users/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ComicEntity create(@PathVariable Integer userId, @PathVariable Integer comicId) {
		return comicService.create(userId, comicId);
	}

}
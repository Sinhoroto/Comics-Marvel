package com.github.bruno.marvel.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.bruno.marvel.domain.model.AuthorList;
import com.github.bruno.marvel.domain.model.Comic;


@FeignClient(value = "MarvelAPI", url = "https://gateway.marvel.com/v1/public")
@Service
public interface MarvelAPI {
	
    @RequestMapping(method = RequestMethod.GET, value = "/comics/{comicId}?ts=2&apikey=2452d8ed84747ab7ff0bf5d605982504&hash=3d464c414cbbf907a1ea3bb3bce90638")
    Comic getComicById(@PathVariable("comicId") Integer comicId);
   	
    @RequestMapping(method = RequestMethod.GET, value = "/comics/{comicId}/creators?ts=2&apikey=2452d8ed84747ab7ff0bf5d605982504&hash=3d464c414cbbf907a1ea3bb3bce90638")
    AuthorList getAuthorsByComicId(@PathVariable("comicId") Integer comicId);
}
package com.github.bruno.marvel.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.bruno.marvel.api.MarvelAPI;
import com.github.bruno.marvel.domain.entity.ComicEntity;
import com.github.bruno.marvel.domain.entity.UserEntity;
import com.github.bruno.marvel.domain.model.Comic;
import com.github.bruno.marvel.domain.repository.ComicRepository;
import com.github.bruno.marvel.domain.repository.UserRepository;

@Service
public class ComicService {
	
	public ComicService() {}
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private MarvelAPI marvel;
	
	@Autowired
	private ComicRepository comicRep;
	
	@Transactional
	public ComicEntity create(Integer userId, Integer comicId) {
		UserEntity userEntity = userRep.findById(userId).get();
		ComicEntity comicEntity = create(comicId);
		userEntity.getComics().add(comicEntity);
		userRep.save(userEntity);
		return comicEntity;
	}
	
	private ComicEntity create(Integer comicId) {
		ComicEntity comicEntity = comicRep.findByComicId(comicId);
		if(comicEntity == null) {
			ComicEntity newComicEntity = toEntity(comicId);
			comicRep.save(newComicEntity);
			return newComicEntity;
		}else{
			return comicEntity;
		}
	}
	
	private ComicEntity toEntity(Integer id) {
		Comic comic = marvel.getComicById(id);
		return new ComicEntity(null, comic.getId(), comic.getTitle(), comic.getPrice(), comic.getIsbn(), comic.getDescription());
	}
	
	
}

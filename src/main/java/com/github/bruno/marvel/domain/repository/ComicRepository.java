package com.github.bruno.marvel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.bruno.marvel.domain.entity.ComicEntity;

public interface ComicRepository extends JpaRepository<ComicEntity, Integer>{

	ComicEntity findByComicId(Integer comicId);
}

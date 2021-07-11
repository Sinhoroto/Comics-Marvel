package com.github.bruno.marvel.domain.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
	
    private String diaDesconto(String isbn) {  

    	String suffixAux = isbn.substring(isbn.length() - 1);
    	int suffix = Integer.parseInt(suffixAux);

        if (suffix == 0 || suffix == 1) {
            return "Monday";
        } else if (suffix == 2 || suffix == 3) {
            return "Tuesday";
        } else if (suffix == 4 || suffix == 5) {
            return "Wednesday";
        } else if (suffix == 6 || suffix == 7) {
            return "Thursday";
        } else {
            return "Friday";
        }
    }

    private Boolean descontoAtivo(String diaDesconto) {
        DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
        return diaDesconto.equals(dayOfWeek.toString());
    }
    
    private Double desconto(Double preco) {
        int porcentagemDesconto = 10;
        Double novoPreco = Double.valueOf(preco - preco * (porcentagemDesconto / 100.00));
        return novoPreco;
    }
	
}

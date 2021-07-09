package com.github.bruno.marvel.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.bruno.marvel.domain.exception.NegocioException;
import com.github.bruno.marvel.domain.entity.UserEntity;
import com.github.bruno.marvel.domain.repository.UserRepository;

@Service
public class CrudUserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserEntity salvar(UserEntity user) {
		UserEntity emailExistente = userRepository.findByEmail(user.getEmail());
		if(emailExistente != null && !emailExistente.equals(user)) {
			throw new NegocioException("Ja exixte um cliente cadastrado com este email.");
		}
		
		return userRepository.save(user);
	}
	
	public void excluir(Long userid) {
		userRepository.deleteById(userid);
	}
}
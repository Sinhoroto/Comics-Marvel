package com.github.bruno.marvel.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Comic")
public class ComicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer comicId;
	private String titulo;
	private Double preco;
	private	String isbn;
	private String descricao;
	
	@JsonBackReference
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_comic", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="comic_id"))
	private Set<UserEntity> user = new HashSet<>();
	
	
	
	public ComicEntity() {}
	
	public ComicEntity(Integer id, Integer comicId, String titulo, Double preco, String isbn, String descricao) {
		super();
		this.id = id;
		this.comicId = comicId;
		this.titulo = titulo;
		this.preco = preco;
		this.isbn = isbn;
		this.descricao = descricao;
	}
	
	
	
	public Set<UserEntity> getUser() {
		return user;
	}

	public void setUser(Set<UserEntity> user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getComicId() {
		return comicId;
	}

	public void setComicId(Integer comicId) {
		this.comicId = comicId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicEntity other = (ComicEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

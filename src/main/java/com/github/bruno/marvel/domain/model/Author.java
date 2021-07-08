package com.github.bruno.marvel.domain.model;

public class Author {

	private Integer id;
	private String fullname;
	
	public Author() {}
	
	public Author(Integer id, String fullname) {
		super();
		this.id = id;
		this.fullname = fullname;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}

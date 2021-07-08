package com.github.bruno.marvel.domain.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorList {

	private List<Author> authors;
	
	public AuthorList() {}

	public AuthorList(List<Author> authors) {
		this.authors = authors;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	@SuppressWarnings("unchecked")
	@JsonProperty("data")
	private void dataDeserializer(Map<String, Object> data) {
		List<Map<String,Object>> results = (List<Map<String, Object>>) data.get("results");
		this.authors = results.stream()
				.map( result -> new Author((Integer) result.get("id"), (String) result.get("fullName")))
				.collect(Collectors.toList());
	}
	
}

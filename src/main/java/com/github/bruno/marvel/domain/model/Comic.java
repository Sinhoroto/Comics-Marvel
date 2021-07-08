package com.github.bruno.marvel.domain.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comic {
	private Integer id;
	private String isbn;
	private String title;
	private String description;
	private double price;
	
	public Comic() {}
	
	public Comic(Integer id, String isbn, String title, String description, double price) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@SuppressWarnings("unchecked")
	@JsonProperty("data")
	private void dataDeserializer(Map<String, Object> data) {
		List<Map<String,Object>> results = (List<Map<String, Object>>) data.get("results");
		results.stream().findFirst().ifPresent( result -> {
				this.id = (Integer) result.get("id");
				this.isbn = (String) result.get("isbn");
				this.title = (String) result.get("title");
				this.description = (String) result.get("description");
				this.price = priceDeserializer((List<Map<String, Object>>) result.get("prices"));
		});
	}
	private Double priceDeserializer(List<Map<String, Object>> prices) {
		
		return (Double) prices.get(0).get("price");
	}
	
}

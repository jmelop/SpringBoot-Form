package com.nex.springboot.form.app.models.domain;

import javax.validation.constraints.NotEmpty;

public class Country {

	private Integer id;
	private String code;
	private String name;

	public Country(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Country() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

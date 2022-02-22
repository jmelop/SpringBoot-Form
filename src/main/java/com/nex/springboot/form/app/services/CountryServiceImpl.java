package com.nex.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nex.springboot.form.app.models.domain.Country;

@Service
public class CountryServiceImpl implements CountryService {

	private List<Country> list;

	public CountryServiceImpl() {
		this.list = Arrays.asList(new Country(1, "ES", "Spain"), new Country(2, "FR", "France"),
				new Country(3, "AR", "Argentina"), new Country(4, "DE", "Germany"));
	}

	@Override
	public List<Country> list() {
		return list;
	}

	@Override
	public Country getById(Integer id) {
		Country result = null;
		for (Country country : this.list) {
			if (id == country.getId()) {
				result = country;
				break;
			}
		}
		return result;
	}

}

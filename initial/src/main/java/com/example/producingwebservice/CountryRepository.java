package com.example.producingwebservice;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Country> countriescdata = new HashMap<>();

	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setCity("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency("EUR");
		spain.setPopulation(46704314);

		countriescdata.put(spain.getCity(), spain);

		Country poland = new Country();
		poland.setCity("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency("PLN");
		poland.setPopulation(38186860);

		countriescdata.put(poland.getCity(), poland);

		Country uk = new Country();
		uk.setCity("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency("GBP");
		uk.setPopulation(63705000);

		countriescdata.put(uk.getCity(), uk);
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countriescdata.get(name);
	}
}


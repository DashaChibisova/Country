package gure.qa.demo.service;

import gure.qa.demo.data.CountryEntity;
import gure.qa.demo.model.Country;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    @Transactional
    public Country addCountry(@Nonnull String countryName, @Nonnull String countryCode) {
        CountryEntity country = new CountryEntity();
        country.setCountryName(countryName);
        country.setCountryCode(countryCode);
        countryRepository.save(country);
        return Country.fromEntity(country);
    }

    @Transactional
    public Country updateCountry(@Nonnull String countryName, @Nonnull String countryCode) {
        CountryEntity country = countryRepository.findByCountryCode(countryCode);
        country.setCountryName(countryName);
        return Country.fromEntity(country);
    }
}

package gure.qa.demo.service;

import gure.qa.demo.data.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {

    CountryEntity findByCountryCode(String countryCode);
}

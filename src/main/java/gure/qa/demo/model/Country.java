package gure.qa.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import gure.qa.demo.data.CountryEntity;

public record Country(@JsonProperty("country_name") String countryName,
                      @JsonProperty("country_code")String countryCode) {

    public  static Country fromEntity(CountryEntity ce) {
        return new Country(
                ce.getCountryName(),
                ce.getCountryCode()

        );
    }
}

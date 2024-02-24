package gure.qa.demo.controller;

import gure.qa.demo.model.Country;
import gure.qa.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestParam String countryName,
                              @RequestParam String countryCode) {
        return countryService.addCountry(countryName, countryCode);

    }

    @PatchMapping("/updateCountry")
    public Country updateCountry(@RequestParam String countryName,
                                 @RequestParam String countryCode) {
        return countryService.updateCountry(countryName, countryCode);

    }
}

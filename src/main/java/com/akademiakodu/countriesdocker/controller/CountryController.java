package com.akademiakodu.countriesdocker.controller;

import com.akademiakodu.countriesdocker.model.Country;
import com.akademiakodu.countriesdocker.model.CountryAPI;
import com.akademiakodu.countriesdocker.model.CountryLanguage;
import com.akademiakodu.countriesdocker.service.CountryLanguageService;
import com.akademiakodu.countriesdocker.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    //przyłączamy warstwę serwisową przez autowired:
    @Autowired
    CountryService countryService;

    @Autowired
    CountryLanguageService countryLanguageService;

    @GetMapping("/{code}")
    public CountryAPI getCountryInfo(@PathVariable String code) {
        Country country = countryService.getCountry(code);


        List<CountryLanguage> countryLanguage = countryLanguageService.getCountryLanguages(code);
        String language = null;
        if (countryLanguage.size() != 0){
             language = countryLanguage.get(0).getLanguage();

        }

        return new CountryAPI(country.getName(),
                country.getContinent(),
                country.getPopulation(),
                country.getLifeExpectancy(),
                language);
    }
}

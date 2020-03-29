package com.akademiakodu.countriesdocker.service;

import com.akademiakodu.countriesdocker.model.CountryLanguage;
import com.akademiakodu.countriesdocker.repository.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {

    private CountryLanguageRepository countryLanguageRepository;
//injecting through constructor:
    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository){
      this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguage>getCountryLanguages(String code) {
        return countryLanguageRepository.findByCountryCode(code);

    }
}

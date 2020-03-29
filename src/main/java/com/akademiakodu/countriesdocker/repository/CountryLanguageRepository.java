package com.akademiakodu.countriesdocker.repository;

import com.akademiakodu.countriesdocker.model.CountryLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends CrudRepository<CountryLanguage, Long> {

    List<CountryLanguage> findByCountryCode(String countryCode);
}

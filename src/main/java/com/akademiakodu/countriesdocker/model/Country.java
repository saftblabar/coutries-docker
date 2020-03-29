package com.akademiakodu.countriesdocker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private Integer population;
    @Column(name = "continent")
    private String continent;
    @Column(name = "life_expectancy")
    private Integer lifeExpectancy;

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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}

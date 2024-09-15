package com.example.Service;

import com.example.Entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CountryService {

    public Country createCountry(Country country);

    public List<Country> getAllCountry();
}

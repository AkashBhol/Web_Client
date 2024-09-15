package com.example.ServiceImpl;

import com.example.Entity.Country;
import com.example.Repository.CountryRepository;
import com.example.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl  implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }
}

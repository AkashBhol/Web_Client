package com.example.controller;

import com.example.Entity.Country;
import com.example.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CountryController {

    @Autowired
    private CountryService  countryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCountry(@RequestBody Country country){
        Country country1 = countryService.createCountry(country);
        return new ResponseEntity<>(country1, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Country> getllCountry(){
        List<Country> allCountry = countryService.getAllCountry();
        return allCountry;

    }
}

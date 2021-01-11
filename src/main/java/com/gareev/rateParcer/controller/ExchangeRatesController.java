package com.gareev.rateParcer.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gareev.rateParcer.entity.ExchangeRates;
import com.gareev.rateParcer.repository.CurrencyRateRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ExchangeRatesController {

    @Autowired
    CurrencyRateRepository currencyRateRepository;

    @GetMapping("/ExchangeRates")
    public ResponseEntity<List<ExchangeRates>> getAllExchangeRates(@RequestParam(required = false) String currencyName) {
        try {
            List<ExchangeRates> ExchangeRates = new ArrayList<ExchangeRates>();

            if (currencyName == null)
                currencyRateRepository.findAll().forEach(ExchangeRates::add);
            else
                currencyRateRepository.findAllByCurrencyName(currencyName).forEach(ExchangeRates::add);

            if (ExchangeRates.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ExchangeRates, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ExchangeRates/{id}")
    public ResponseEntity<ExchangeRates> getExchangeRatesById(@PathVariable("id") long id) {
        Optional<ExchangeRates> ExchangeRatesData = currencyRateRepository.findById(id);

        if (ExchangeRatesData.isPresent()) {
            return new ResponseEntity<>(ExchangeRatesData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ExchangeRates")
    public ResponseEntity<ExchangeRates> createExchangeRates(@RequestBody ExchangeRates exchangeRates) {
        try {
            ExchangeRates _ExchangeRates = currencyRateRepository.save(new ExchangeRates(exchangeRates.getCurrencyCode(), exchangeRates.getCurrencyName(), exchangeRates.getRateValue()));
            return new ResponseEntity<>(_ExchangeRates, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/ExchangeRates/{id}")
    public ResponseEntity<ExchangeRates> updateExchangeRates(@PathVariable("id") long id, @RequestBody ExchangeRates ExchangeRates) {
        Optional<ExchangeRates> ExchangeRatesData = currencyRateRepository.findById(id);

        if (ExchangeRatesData.isPresent()) {
            ExchangeRates _ExchangeRates = ExchangeRatesData.get();
            _ExchangeRates.setCurrencyName(ExchangeRates.getCurrencyName());
            _ExchangeRates.setCurrencyCode(ExchangeRates.getCurrencyCode());
            return new ResponseEntity<>(currencyRateRepository.save(_ExchangeRates), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ExchangeRates/{id}")
    public ResponseEntity<HttpStatus> deleteExchangeRates(@PathVariable("id") long id) {
        try {
            currencyRateRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/ExchangeRates")
    public ResponseEntity<HttpStatus> deleteAllExchangeRates() {
        try {
            currencyRateRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }


}

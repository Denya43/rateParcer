package com.gareev.rateParcer.services;

import com.gareev.rateParcer.entity.ExchangeRates;
import com.gareev.rateParcer.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRateService {

    @Autowired
    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository){
        this.currencyRateRepository = currencyRateRepository;
    }

    public void createCurrencyRate(ExchangeRates exchangeRates){
        currencyRateRepository.save(exchangeRates);
    }


    public List<ExchangeRates> findAll(){
        return currencyRateRepository.findAll();
    }

    public ExchangeRates findById(Long userId){
        return currencyRateRepository.findById(userId).orElse(null);
    }

    public List<ExchangeRates> findAllByCurrencyName(String currency){
        return currencyRateRepository.findAllByCurrencyName(currency);
    }


}

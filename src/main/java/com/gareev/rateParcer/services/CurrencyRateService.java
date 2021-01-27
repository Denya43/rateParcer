package com.gareev.rateParcer.services;

import com.gareev.rateParcer.entity.Valute;
import com.gareev.rateParcer.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRateService {

    @Autowired
    private final CurrencyRateRepository currencyExchangeRates;

    public CurrencyRateService(CurrencyRateRepository currencyExchangeRates){
        this.currencyExchangeRates = currencyExchangeRates;
    }

    public void createCurrencyRate(Valute exchangeRates){
        currencyExchangeRates.save(exchangeRates);
    }

    public List<Valute> findAll(){
        return currencyExchangeRates.findAll();
    }

    public Valute findById(Long userId){
        return currencyExchangeRates.findById(userId).orElse(null);
    }

    public List<Valute> findAllByName(String currency){
        return currencyExchangeRates.findAllByName(currency);
    }


}

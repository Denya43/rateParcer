package com.gareev.rateParcer.services;

import com.gareev.rateParcer.entity.ExchangeRates;
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

    public void createCurrencyRate(ExchangeRates exchangeRates){
        currencyExchangeRates.save(exchangeRates);
    }


    public List<ExchangeRates> findAll(){
        return currencyExchangeRates.findAll();
    }

    public ExchangeRates findById(Long userId){
        return currencyExchangeRates.findById(userId).orElse(null);
    }

    public List<ExchangeRates> findAllByCurrencyName(String currency){
        return currencyExchangeRates.findAllByCurrencyName(currency);
    }


}

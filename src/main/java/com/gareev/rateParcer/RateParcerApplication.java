package com.gareev.rateParcer;

import com.gareev.rateParcer.controller.ExchangeRatesController;
import com.gareev.rateParcer.entity.ExchangeRates;
import com.gareev.rateParcer.services.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RateParcerApplication {

	@Autowired
	private CurrencyRateService currencyRateService;

	//@Autowired
	//private ExchangeRatesController exchangeRatesController;

	public static void main(String[] args) {
		SpringApplication.run(RateParcerApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		ExchangeRates exchangeRates = new ExchangeRates();
		exchangeRates.setCurrencyName("Euro");
		exchangeRates.setCurrencyCode("EUR");
		exchangeRates.setRateValue(77);

		currencyRateService.createCurrencyRate(exchangeRates);

		//currencyRateService.findAll().forEach(it-> System.out.println(it));
		currencyRateService.findAllByCurrencyName("Euro").forEach(it-> System.out.println(it));
	}

}

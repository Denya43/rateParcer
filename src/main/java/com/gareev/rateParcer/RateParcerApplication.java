package com.gareev.rateParcer;

import com.gareev.rateParcer.entity.Valute;
import com.gareev.rateParcer.services.CurrencyRateService;
import com.gareev.rateParcer.services.GetCursOnDateResultParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;


@SpringBootApplication
public class RateParcerApplication {

	@Autowired
	private CurrencyRateService currencyRateService;

	@Autowired
	private GetCursOnDateResultParserService getCursOnDateResultParserService;

	public static void main(String[] args) {
		SpringApplication.run(RateParcerApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		//Valute valute = new Valute("USD", "");
		//valute.setName("Euro");
		//valute.setCode("EUR");
		//valute.setCurs(new BigDecimal(77));

		//currencyRateService.createCurrencyRate(valute);

		//currencyRateService.findAll().forEach(it-> System.out.println(it));
		//currencyRateService.findAllByName("Euro").forEach(it-> System.out.println(it));


		try {
			currencyRateService.createCurrencyRate(getCursOnDateResultParserService.getValuteFromCB());
		} catch (Exception e) {
			e.printStackTrace();
		}
		currencyRateService.findAll().forEach(it-> System.out.println(it));
		/*try {
			System.out.println(getCursOnDateResultParserService.getValuteFromCB().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		 */
	}



}

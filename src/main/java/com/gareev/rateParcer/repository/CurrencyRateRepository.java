package com.gareev.rateParcer.repository;

import com.gareev.rateParcer.entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRateRepository extends JpaRepository<ExchangeRates, Long> {


    List<ExchangeRates> findAllByName(String currency);//просто правильное название метода даст возможность
    //избежать запросов на SQL

/*    @Query("select u from Users u where u.email like '%@gmail.com%'")//если этого мало можно написать
        //собственный запрос на языке похожем на SQL
    List<ExchangeRates> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
        //если и этого мало - можно написать запрос на чистом SQL и все это будет работать
    List<ExchangeRates> findWhereNameStartsFromSmith();*/
}
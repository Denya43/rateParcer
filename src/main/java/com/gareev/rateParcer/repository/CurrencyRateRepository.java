package com.gareev.rateParcer.repository;

import com.gareev.rateParcer.entity.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRateRepository extends JpaRepository<Valute, Long> {


    List<Valute> findAllByName(String name);
    //List<Valute> findAllByCurrencyCode(String name);
    //просто правильное название метода даст возможность
    //избежать запросов на SQL
/*    @Query("select u from Users u where u.email like '%@gmail.com%'")//если этого мало можно написать
        //собственный запрос на языке похожем на SQL
    List<ExchangeRates> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
        //если и этого мало - можно написать запрос на чистом SQL и все это будет работать
    List<ExchangeRates> findWhereNameStartsFromSmith();*/
}
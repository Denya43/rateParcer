package com.gareev.rateParcer.entity;

import javax.persistence.*;

@Entity
@Table(name = "exchangerates")
public class ExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String currency_code;

    @Column
    private String currency_name;

    @Column
    private double rate_value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public double getRate_value() {
        return rate_value;
    }

    public void setRate_value(double rate_value) {
        this.rate_value = rate_value;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", currency='" + currency_name + '\'' +
                ", codeCurrency='" + currency_code + '\'' +
                ", rate=" + rate_value +
                '}';
    }
}

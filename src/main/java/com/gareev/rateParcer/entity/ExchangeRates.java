package com.gareev.rateParcer.entity;

import javax.persistence.*;

@Entity
@Table(name = "exchangerates")
public class ExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "rate_value")
    private double rateValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getRateValue() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", currency='" + currencyName + '\'' +
                ", codeCurrency='" + currencyCode + '\'' +
                ", rate=" + rateValue +
                '}';
    }
}

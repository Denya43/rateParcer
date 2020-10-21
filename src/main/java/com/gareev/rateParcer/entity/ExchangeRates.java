package com.gareev.rateParcer.entity;

import javax.persistence.*;

@Entity
@Table(name = "exchangerates")
public class ExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codeсurrency;

    @Column
    private String currency;

    @Column
    private double rate;

//getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeRate() {
        return codeсurrency;
    }

    public void setCodeRate(String codeRate) {
        this.codeсurrency = codeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", codeCurrency='" + codeсurrency + '\'' +
                ", rate=" + rate +
                '}';
    }
}

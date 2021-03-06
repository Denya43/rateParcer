package com.gareev.rateParcer.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "valute")
public class Valute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vname")
    private String name;

    @Column(name = "chсode")
    private String chcode;

    @Column(name = "code")
    private int code;

    @Column(name = "curs")
    private BigDecimal curs;

    @Column(name = "nom")
    private BigDecimal nom;

    @Column(name = "update_date")
    private Date updateDate;

    public Valute(){

    }

    public Valute(String name, String chсode, int code, BigDecimal curs, BigDecimal nom, Date updateDate){
        this.name = name;
        this.chcode = chсode;
        this.code = code;
        this.nom = nom;
        this.curs = curs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChCode() {
        return chcode;
    }

    public void setChCode(String chCode) {
        this.chcode = chCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BigDecimal getCurs() {
        return curs;
    }

    public void setCurs(BigDecimal curs) {
        this.curs = curs;
    }

    public BigDecimal getNom() {
        return nom;
    }

    public void setNom(BigDecimal nom) {
        this.nom = nom;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "id=" + id + '\n' +
                ", name=" + name + '\n' +
                ", chCode=" + chcode + '\n' +
                ", code=" + code +  '\n' +
                ", curs=" + curs +  '\n' +
                ", nom=" + nom +  '\n' +
                ", update_date=" + updateDate + '\n' +
                '}';
    }
}

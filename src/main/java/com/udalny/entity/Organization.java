package com.udalny.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATIONS")
public class Organization {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "CName")
    private String cname;

    @Column(name = "INN")
    private String inn;

    @Column(name = "KPP")
    private String kpp;

    public Organization() {
    }

    public Organization(String inn, String kpp, String cname) {
        this.inn = inn;
        this.kpp = kpp;
        this.cname = cname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }
}

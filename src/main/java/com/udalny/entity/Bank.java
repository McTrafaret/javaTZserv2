package com.udalny.entity;

import javax.persistence.*;

@Entity
@Table(name = "BANKS")
public class Bank {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "BIC")
    private String bic;

    public Bank() {
    }

    public Bank(String bic) {
        this.bic = bic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}

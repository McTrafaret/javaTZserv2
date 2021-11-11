package com.udalny.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "TreasuryAccountNumber")
    private String treasuryAccountNumber;

    public Account() {
    }

    public Account(String accountNumber, String treasuryAccountNumber) {
        this.accountNumber = accountNumber;
        this.treasuryAccountNumber = treasuryAccountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTreasuryAccountNumber() {
        return treasuryAccountNumber;
    }

    public void setTreasuryAccountNumber(String treasuryAccountNumber) {
        this.treasuryAccountNumber = treasuryAccountNumber;
    }
}

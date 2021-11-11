package com.udalny.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DOCUMENTS")
public class Document {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private Date docDate;

    @Column(name = "DocGUID")
    private String docGUID;

    @Column(name = "OperType")
    private String operType;

    @Column(name = "AmountOut")
    private BigDecimal amountOut;

    @OneToOne
    @JoinColumn(name = "PayId")
    private Organization payer;

    @OneToOne
    @JoinColumn(name = "PayAccountId")
    private Account payerAccount;

    @OneToOne
    @JoinColumn(name = "PayBankId")
    private Bank payerBank;

    @OneToOne
    @JoinColumn(name = "RecId")
    private Organization receiver;

    @OneToOne
    @JoinColumn(name = "RecAccountId")
    private Account receiverAccount;

    @OneToOne
    @JoinColumn(name = "RecBankId")
    private Bank receiverBank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocGUID() {
        return docGUID;
    }

    public void setDocGUID(String docGUID) {
        this.docGUID = docGUID;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    public Organization getPayer() {
        return payer;
    }

    public void setPayer(Organization payer) {
        this.payer = payer;
    }

    public Account getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(Account payerAccount) {
        this.payerAccount = payerAccount;
    }

    public Bank getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(Bank payerBank) {
        this.payerBank = payerBank;
    }

    public Organization getReceiver() {
        return receiver;
    }

    public void setReceiver(Organization receiver) {
        this.receiver = receiver;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Bank getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(Bank receiverBank) {
        this.receiverBank = receiverBank;
    }
}

package com.udalny.entity.summarydocument;

import java.math.BigDecimal;
import java.util.Date;


public class SummaryDocument {
    private String docNum;
    private Date docDate;
    private String docGuid;
    private String operType;
    private BigDecimal amountOut;
    private String purpose;

    private InfPay infPay;
    private BankPay bankPay;
    private InfRcp infRcp;
    private BankRcp bankRcp;

    public String getDocNum() {
        return docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getDocGuid() {
        return docGuid;
    }

    public String getOperType() {
        return operType;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public String getPurpose() {
        return purpose;
    }

    public InfPay getInfPay() {
        return infPay;
    }

    public BankPay getBankPay() {
        return bankPay;
    }

    public InfRcp getInfRcp() {
        return infRcp;
    }

    public BankRcp getBankRcp() {
        return bankRcp;
    }

    @Override
    public String toString() {
        return "SummaryDocument{" +
                "docNum=" + docNum +
                ", docDate=" + docDate +
                ", docGuid='" + docGuid + '\'' +
                ", operType='" + operType + '\'' +
                ", amountOut=" + amountOut +
                ", purpose='" + purpose + '\'' +
                ", infPay=" + infPay +
                ", bankPay=" + bankPay +
                ", infRcp=" + infRcp +
                ", bankRcp=" + bankRcp +
                '}';
    }
}

package com.udalny.entity.statistics;

public class OrganizationInfoObject {

    private final String cname;
    private final Long pay;
    private final Long rec;

    public OrganizationInfoObject(String cname, Long pay, Long rec) {
        this.cname = cname;
        this.pay = pay;
        this.rec = rec;
    }

    public String getCname() {
        return cname;
    }

    public Long getPay() {
        return pay;
    }

    public Long getRec() {
        return rec;
    }

    @Override
    public String toString() {
        return "OrganizationInfoObject{" +
                "cname='" + cname + '\'' +
                ", pay=" + pay +
                ", rec=" + rec +
                '}';
    }
}

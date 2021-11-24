package com.udalny.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PT_DOCUMENTS")
public class PTDocumentEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "GuidReceived")
    private String guidReceived;

    @Column(name = "NumReceived")
    private String numReceived;

    @Column(name = "DateReceived")
    private Date dateReceived;

    @OneToOne
    @JoinColumn(name = "SenderOrganizationName")
    private Organization senderOrganizationName;

    @Column(name = "AmountSend")
    private BigDecimal amountSend;

    @Column(name = "GuidSend")
    private String guidSend;

    @Column(name = "TypeSend")
    private String typeSend;

    @Column(name = "TypeNameSend")
    private String typeNameSend;

    @Column(name = "NumSend")
    private String numSend;

    @Column(name = "DateSend")
    private Date dateSend;

    @OneToOne
    @JoinColumn(name = "ReceiverOrganizationName")
    private Organization receiverOrganizationName;

    @Column(name = "RejectionReason")
    private String rejectionReason;

    public String getGuidReceived() {
        return guidReceived;
    }

    public void setGuidReceived(String guidReceived) {
        this.guidReceived = guidReceived;
    }

    public String getNumReceived() {
        return numReceived;
    }

    public void setNumReceived(String numReceived) {
        this.numReceived = numReceived;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Organization getSenderOrganizationName() {
        return senderOrganizationName;
    }

    public void setSenderOrganizationName(Organization senderOrganizationName) {
        this.senderOrganizationName = senderOrganizationName;
    }

    public BigDecimal getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(BigDecimal amountSend) {
        this.amountSend = amountSend;
    }

    public String getGuidSend() {
        return guidSend;
    }

    public void setGuidSend(String guidSend) {
        this.guidSend = guidSend;
    }

    public String getTypeSend() {
        return typeSend;
    }

    public void setTypeSend(String typeSend) {
        this.typeSend = typeSend;
    }

    public String getTypeNameSend() {
        return typeNameSend;
    }

    public void setTypeNameSend(String typeNameSend) {
        this.typeNameSend = typeNameSend;
    }

    public String getNumSend() {
        return numSend;
    }

    public void setNumSend(String numSend) {
        this.numSend = numSend;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public Organization getReceiverOrganizationName() {
        return receiverOrganizationName;
    }

    public void setReceiverOrganizationName(Organization receiverOrganizationName) {
        this.receiverOrganizationName = receiverOrganizationName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "PTDocument{" +
                "guidReceived='" + guidReceived + '\'' +
                ", numReceived='" + numReceived + '\'' +
                ", dateReceived=" + dateReceived +
                ", senderOrganizationName='" + senderOrganizationName + '\'' +
                ", amountSend=" + amountSend +
                ", guidSend='" + guidSend + '\'' +
                ", typeSend='" + typeSend + '\'' +
                ", nameSend='" + typeNameSend + '\'' +
                ", numSend='" + numSend + '\'' +
                ", dateSend=" + dateSend +
                ", receiverOrganizationName='" + receiverOrganizationName + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}

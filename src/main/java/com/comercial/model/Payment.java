/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author asira
 */
@Entity
@Table(name = "payment", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment")
    , @NamedQuery(name = "Payment.findByCollectionId", query = "SELECT p FROM Payment p WHERE p.collectionId = :collectionId")
    , @NamedQuery(name = "Payment.findByDate", query = "SELECT p FROM Payment p WHERE p.date = :date")
    , @NamedQuery(name = "Payment.findByTransactionAmount", query = "SELECT p FROM Payment p WHERE p.transactionAmount = :transactionAmount")
    , @NamedQuery(name = "Payment.findByTotalPaidAmount", query = "SELECT p FROM Payment p WHERE p.totalPaidAmount = :totalPaidAmount")
    , @NamedQuery(name = "Payment.findByShippingCost", query = "SELECT p FROM Payment p WHERE p.shippingCost = :shippingCost")
    , @NamedQuery(name = "Payment.findByCurrencyId", query = "SELECT p FROM Payment p WHERE p.currencyId = :currencyId")
    , @NamedQuery(name = "Payment.findByStatus", query = "SELECT p FROM Payment p WHERE p.status = :status")
    , @NamedQuery(name = "Payment.findByStatusDetail", query = "SELECT p FROM Payment p WHERE p.statusDetail = :statusDetail")
    , @NamedQuery(name = "Payment.findByOperationType", query = "SELECT p FROM Payment p WHERE p.operationType = :operationType")
    , @NamedQuery(name = "Payment.findByDateApproved", query = "SELECT p FROM Payment p WHERE p.dateApproved = :dateApproved")
    , @NamedQuery(name = "Payment.findByDateCreated", query = "SELECT p FROM Payment p WHERE p.dateCreated = :dateCreated")
    , @NamedQuery(name = "Payment.findByLastModified", query = "SELECT p FROM Payment p WHERE p.lastModified = :lastModified")
    , @NamedQuery(name = "Payment.findByAmountRefunded", query = "SELECT p FROM Payment p WHERE p.amountRefunded = :amountRefunded")
    , @NamedQuery(name = "Payment.findByPreferenceId", query = "SELECT p FROM Payment p WHERE p.preferenceId = :preferenceId")
    , @NamedQuery(name = "Payment.findByExternalReference", query = "SELECT p FROM Payment p WHERE p.externalReference = :externalReference")
    , @NamedQuery(name = "Payment.findByPaymentType", query = "SELECT p FROM Payment p WHERE p.paymentType = :paymentType")
    , @NamedQuery(name = "Payment.findByMerchantOrderId", query = "SELECT p FROM Payment p WHERE p.merchantOrderId = :merchantOrderId")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment")
    private Integer idPayment;
    @Basic(optional = false)
    @Column(name = "collection_id")
    private String collectionId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "transaction_amount")
    private double transactionAmount;
    @Basic(optional = false)
    @Column(name = "total_paid_amount")
    private double totalPaidAmount;
    @Basic(optional = false)
    @Column(name = "shipping_cost")
    private double shippingCost;
    @Column(name = "currency_id")
    private String currencyId;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "status_detail")
    private String statusDetail;
    @Basic(optional = false)
    @Column(name = "operation_type")
    private String operationType;
    @Column(name = "date_approved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Basic(optional = false)
    @Column(name = "amount_refunded")
    private double amountRefunded;
    @Basic(optional = false)
    @Column(name = "preference_id")
    private String preferenceId;
    @Basic(optional = false)
    @Column(name = "external_reference")
    private String externalReference;
    @Column(name = "payment_type")
    private String paymentType;
    @Basic(optional = false)
    @Column(name = "merchant_order_id")
    private String merchantOrderId;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne(optional = false)
    private Order idOrder;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Payment(Integer idPayment, String collectionId, double transactionAmount, double totalPaidAmount, double shippingCost, String status, String statusDetail, String operationType, double amountRefunded, String preferenceId, String externalReference, String merchantOrderId) {
        this.idPayment = idPayment;
        this.collectionId = collectionId;
        this.transactionAmount = transactionAmount;
        this.totalPaidAmount = totalPaidAmount;
        this.shippingCost = shippingCost;
        this.status = status;
        this.statusDetail = statusDetail;
        this.operationType = operationType;
        this.amountRefunded = amountRefunded;
        this.preferenceId = preferenceId;
        this.externalReference = externalReference;
        this.merchantOrderId = merchantOrderId;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public double getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(double amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Payment[ idPayment=" + idPayment + " ]";
    }
    
}

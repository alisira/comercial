/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author asira
 */
@Entity
@Table(name = "purchase", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p")
    , @NamedQuery(name = "Purchase.findByIdPurchase", query = "SELECT p FROM Purchase p WHERE p.idPurchase = :idPurchase")
    , @NamedQuery(name = "Purchase.findByIdPayment", query = "SELECT p FROM Purchase p WHERE p.idPayment = :idPayment")
    , @NamedQuery(name = "Purchase.findByDate", query = "SELECT p FROM Purchase p WHERE p.date = :date")
    , @NamedQuery(name = "Purchase.findByCreatedAt", query = "SELECT p FROM Purchase p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Purchase.findByUpdatedAt", query = "SELECT p FROM Purchase p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Purchase.findByStatus", query = "SELECT p FROM Purchase p WHERE p.status = :status")})
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_purchase")
    private Integer idPurchase;
    @Basic(optional = false)
    @Column(name = "id_payment")
    private int idPayment;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "status")
    private Short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPurchase")
    private Collection<DiscountPurchase> discountPurchaseCollection;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne(optional = false)
    private Order1 idOrder;
    @JoinColumn(name = "id_ship_info", referencedColumnName = "id_ship_info")
    @ManyToOne(optional = false)
    private ShipInfo idShipInfo;

    public Purchase() {
    }

    public Purchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Purchase(Integer idPurchase, int idPayment) {
        this.idPurchase = idPurchase;
        this.idPayment = idPayment;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Collection<DiscountPurchase> getDiscountPurchaseCollection() {
        return discountPurchaseCollection;
    }

    public void setDiscountPurchaseCollection(Collection<DiscountPurchase> discountPurchaseCollection) {
        this.discountPurchaseCollection = discountPurchaseCollection;
    }

    public Order1 getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order1 idOrder) {
        this.idOrder = idOrder;
    }

    public ShipInfo getIdShipInfo() {
        return idShipInfo;
    }

    public void setIdShipInfo(ShipInfo idShipInfo) {
        this.idShipInfo = idShipInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPurchase != null ? idPurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.idPurchase == null && other.idPurchase != null) || (this.idPurchase != null && !this.idPurchase.equals(other.idPurchase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Purchase[ idPurchase=" + idPurchase + " ]";
    }
    
}

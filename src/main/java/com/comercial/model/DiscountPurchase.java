/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "discount_purchase", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DiscountPurchase.findAll", query = "SELECT d FROM DiscountPurchase d")
    , @NamedQuery(name = "DiscountPurchase.findByIdDiscountPurchase", query = "SELECT d FROM DiscountPurchase d WHERE d.idDiscountPurchase = :idDiscountPurchase")
    , @NamedQuery(name = "DiscountPurchase.findByDiscount", query = "SELECT d FROM DiscountPurchase d WHERE d.discount = :discount")
    , @NamedQuery(name = "DiscountPurchase.findByCreatedAt", query = "SELECT d FROM DiscountPurchase d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "DiscountPurchase.findByUpdatedAt", query = "SELECT d FROM DiscountPurchase d WHERE d.updatedAt = :updatedAt")})
public class DiscountPurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discount_purchase")
    private Integer idDiscountPurchase;
    @Column(name = "discount")
    private BigInteger discount;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_discount", referencedColumnName = "id_discount")
    @ManyToOne(optional = false)
    private Discount idDiscount;
    @JoinColumn(name = "id_purchase", referencedColumnName = "id_purchase")
    @ManyToOne(optional = false)
    private Purchase idPurchase;

    public DiscountPurchase() {
    }

    public DiscountPurchase(Integer idDiscountPurchase) {
        this.idDiscountPurchase = idDiscountPurchase;
    }

    public Integer getIdDiscountPurchase() {
        return idDiscountPurchase;
    }

    public void setIdDiscountPurchase(Integer idDiscountPurchase) {
        this.idDiscountPurchase = idDiscountPurchase;
    }

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
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

    public Discount getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Discount idDiscount) {
        this.idDiscount = idDiscount;
    }

    public Purchase getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Purchase idPurchase) {
        this.idPurchase = idPurchase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscountPurchase != null ? idDiscountPurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountPurchase)) {
            return false;
        }
        DiscountPurchase other = (DiscountPurchase) object;
        if ((this.idDiscountPurchase == null && other.idDiscountPurchase != null) || (this.idDiscountPurchase != null && !this.idDiscountPurchase.equals(other.idDiscountPurchase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.DiscountPurchase[ idDiscountPurchase=" + idDiscountPurchase + " ]";
    }
    
}

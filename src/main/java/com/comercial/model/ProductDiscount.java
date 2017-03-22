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
@Table(name = "product_discount", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProductDiscount.findAll", query = "SELECT p FROM ProductDiscount p")
    , @NamedQuery(name = "ProductDiscount.findByIdProductDiscount", query = "SELECT p FROM ProductDiscount p WHERE p.idProductDiscount = :idProductDiscount")
    , @NamedQuery(name = "ProductDiscount.findByIdProduct", query = "SELECT p FROM ProductDiscount p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "ProductDiscount.findByIdDiscount", query = "SELECT p FROM ProductDiscount p WHERE p.idDiscount = :idDiscount")
    , @NamedQuery(name = "ProductDiscount.findByCreatedAt", query = "SELECT p FROM ProductDiscount p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "ProductDiscount.findByUpdatedAt", query = "SELECT p FROM ProductDiscount p WHERE p.updatedAt = :updatedAt")})
public class ProductDiscount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_discount")
    private Integer idProductDiscount;
    @Basic(optional = false)
    @Column(name = "id_product")
    private long idProduct;
    @Basic(optional = false)
    @Column(name = "id_discount")
    private long idDiscount;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public ProductDiscount() {
    }

    public ProductDiscount(Integer idProductDiscount) {
        this.idProductDiscount = idProductDiscount;
    }

    public ProductDiscount(Integer idProductDiscount, long idProduct, long idDiscount) {
        this.idProductDiscount = idProductDiscount;
        this.idProduct = idProduct;
        this.idDiscount = idDiscount;
    }

    public Integer getIdProductDiscount() {
        return idProductDiscount;
    }

    public void setIdProductDiscount(Integer idProductDiscount) {
        this.idProductDiscount = idProductDiscount;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(long idDiscount) {
        this.idDiscount = idDiscount;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductDiscount != null ? idProductDiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDiscount)) {
            return false;
        }
        ProductDiscount other = (ProductDiscount) object;
        if ((this.idProductDiscount == null && other.idProductDiscount != null) || (this.idProductDiscount != null && !this.idProductDiscount.equals(other.idProductDiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.ProductDiscount[ idProductDiscount=" + idProductDiscount + " ]";
    }
    
}

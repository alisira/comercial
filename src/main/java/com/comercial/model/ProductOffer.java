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
@Table(name = "product_offer", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProductOffer.findAll", query = "SELECT p FROM ProductOffer p")
    , @NamedQuery(name = "ProductOffer.findByIdOffer", query = "SELECT p FROM ProductOffer p WHERE p.idOffer = :idOffer")
    , @NamedQuery(name = "ProductOffer.findByCreatedAt", query = "SELECT p FROM ProductOffer p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "ProductOffer.findByUpdatedAt", query = "SELECT p FROM ProductOffer p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "ProductOffer.findByIdProductOffer", query = "SELECT p FROM ProductOffer p WHERE p.idProductOffer = :idProductOffer")
    , @NamedQuery(name = "ProductOffer.findByIdProduct", query = "SELECT p FROM ProductOffer p WHERE p.idProduct = :idProduct")})
public class ProductOffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_offer")
    private long idOffer;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_offer")
    private Integer idProductOffer;
    @Column(name = "id_product")
    private Integer idProduct;

    public ProductOffer() {
    }

    public ProductOffer(Integer idProductOffer) {
        this.idProductOffer = idProductOffer;
    }

    public ProductOffer(Integer idProductOffer, long idOffer) {
        this.idProductOffer = idProductOffer;
        this.idOffer = idOffer;
    }

    public long getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(long idOffer) {
        this.idOffer = idOffer;
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

    public Integer getIdProductOffer() {
        return idProductOffer;
    }

    public void setIdProductOffer(Integer idProductOffer) {
        this.idProductOffer = idProductOffer;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductOffer != null ? idProductOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOffer)) {
            return false;
        }
        ProductOffer other = (ProductOffer) object;
        if ((this.idProductOffer == null && other.idProductOffer != null) || (this.idProductOffer != null && !this.idProductOffer.equals(other.idProductOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.ProductOffer[ idProductOffer=" + idProductOffer + " ]";
    }
    
}

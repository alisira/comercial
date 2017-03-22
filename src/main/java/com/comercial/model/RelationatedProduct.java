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
@Table(name = "relationated_product", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RelationatedProduct.findAll", query = "SELECT r FROM RelationatedProduct r")
    , @NamedQuery(name = "RelationatedProduct.findByCreatedAt", query = "SELECT r FROM RelationatedProduct r WHERE r.createdAt = :createdAt")
    , @NamedQuery(name = "RelationatedProduct.findByUpdatedAt", query = "SELECT r FROM RelationatedProduct r WHERE r.updatedAt = :updatedAt")
    , @NamedQuery(name = "RelationatedProduct.findByIdRelationatedProduct", query = "SELECT r FROM RelationatedProduct r WHERE r.idRelationatedProduct = :idRelationatedProduct")
    , @NamedQuery(name = "RelationatedProduct.findByIdProduct", query = "SELECT r FROM RelationatedProduct r WHERE r.idProduct = :idProduct")
    , @NamedQuery(name = "RelationatedProduct.findByIdProductRelation", query = "SELECT r FROM RelationatedProduct r WHERE r.idProductRelation = :idProductRelation")})
public class RelationatedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_relationated_product")
    private Integer idRelationatedProduct;
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "id_product_relation")
    private Integer idProductRelation;

    public RelationatedProduct() {
    }

    public RelationatedProduct(Integer idRelationatedProduct) {
        this.idRelationatedProduct = idRelationatedProduct;
    }

    public RelationatedProduct(Integer idRelationatedProduct, Date createdAt, Date updatedAt) {
        this.idRelationatedProduct = idRelationatedProduct;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Integer getIdRelationatedProduct() {
        return idRelationatedProduct;
    }

    public void setIdRelationatedProduct(Integer idRelationatedProduct) {
        this.idRelationatedProduct = idRelationatedProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProductRelation() {
        return idProductRelation;
    }

    public void setIdProductRelation(Integer idProductRelation) {
        this.idProductRelation = idProductRelation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelationatedProduct != null ? idRelationatedProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationatedProduct)) {
            return false;
        }
        RelationatedProduct other = (RelationatedProduct) object;
        if ((this.idRelationatedProduct == null && other.idRelationatedProduct != null) || (this.idRelationatedProduct != null && !this.idRelationatedProduct.equals(other.idRelationatedProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.RelationatedProduct[ idRelationatedProduct=" + idRelationatedProduct + " ]";
    }
    
}

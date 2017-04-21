/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

@JsonInclude(Include.NON_NULL)
public class RelationatedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)

    @Column(name = "created_at")
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at")
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id_relationated_product")
    private Long idRelationatedProduct;

    @Column(name = "id_product_relation")
    private Long idProductRelation;

    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    //@JsonIgnore
    private Products idProduct;

    public RelationatedProduct() {
    }

    public RelationatedProduct(Long idRelationatedProduct) {
        this.idRelationatedProduct = idRelationatedProduct;
    }

    public RelationatedProduct(Long idRelationatedProduct, Date createdAt, Date updatedAt) {
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

    public Long getIdRelationatedProduct() {
        return idRelationatedProduct;
    }

    public void setIdRelationatedProduct(Long idRelationatedProduct) {
        this.idRelationatedProduct = idRelationatedProduct;
    }

    public Products getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Products idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdProductRelation() {
        return idProductRelation;
    }

    public void setIdProductRelation(Long idProductRelation) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author asira
 */
@Entity
@Table(name = "purpose", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Purpose.findAll", query = "SELECT p FROM Purpose p")
    , @NamedQuery(name = "Purpose.findByIdPurpose", query = "SELECT p FROM Purpose p WHERE p.idPurpose = :idPurpose")
    , @NamedQuery(name = "Purpose.findByDenomination", query = "SELECT p FROM Purpose p WHERE p.denomination = :denomination")
    , @NamedQuery(name = "Purpose.findByStatus", query = "SELECT p FROM Purpose p WHERE p.status = :status")})
public class Purpose implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_purpose")
    private Integer idPurpose;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "idPurpose")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idTaskAction")
    private Collection<Products> productsCollection;

    public Purpose() {
    }

    public Purpose(Integer idPurpose) {
        this.idPurpose = idPurpose;
    }

    public Purpose(Integer idPurpose, String denomination, short status) {
        this.idPurpose = idPurpose;
        this.denomination = denomination;
        this.status = status;
    }

    public Integer getIdPurpose() {
        return idPurpose;
    }

    public void setIdPurpose(Integer idPurpose) {
        this.idPurpose = idPurpose;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPurpose != null ? idPurpose.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purpose)) {
            return false;
        }
        Purpose other = (Purpose) object;
        if ((this.idPurpose == null && other.idPurpose != null) || (this.idPurpose != null && !this.idPurpose.equals(other.idPurpose))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Purpose[ idPurpose=" + idPurpose + " ]";
    }
    
}

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author asira
 */
@Entity
@Table(name = "enviroment", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Enviroment.findAll", query = "SELECT e FROM Enviroment e")
    , @NamedQuery(name = "Enviroment.findByIdEnviroment", query = "SELECT e FROM Enviroment e WHERE e.idEnviroment = :idEnviroment")
    , @NamedQuery(name = "Enviroment.findByDenomination", query = "SELECT e FROM Enviroment e WHERE e.denomination = :denomination")
    , @NamedQuery(name = "Enviroment.findByCreatedAt", query = "SELECT e FROM Enviroment e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "Enviroment.findByUpdatedAt", query = "SELECT e FROM Enviroment e WHERE e.updatedAt = :updatedAt")
    , @NamedQuery(name = "Enviroment.findByStatus", query = "SELECT e FROM Enviroment e WHERE e.status = :status")
    , @NamedQuery(name = "Enviroment.findByIdImage", query = "SELECT e FROM Enviroment e WHERE e.idImage = :idImage")})
public class Enviroment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enviroment")
    private Integer idEnviroment;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Column(name = "id_image")
    private Integer idImage;

    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idTaskAction")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnviroment")
    private Collection<Products> productsCollection;

    public Enviroment() {
    }

    public Enviroment(Integer idEnviroment) {
        this.idEnviroment = idEnviroment;
    }

    public Enviroment(Integer idEnviroment, String denomination, short status) {
        this.idEnviroment = idEnviroment;
        this.denomination = denomination;
        this.status = status;
    }

    public Integer getIdEnviroment() {
        return idEnviroment;
    }

    public void setIdEnviroment(Integer idEnviroment) {
        this.idEnviroment = idEnviroment;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
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
        hash += (idEnviroment != null ? idEnviroment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enviroment)) {
            return false;
        }
        Enviroment other = (Enviroment) object;
        if ((this.idEnviroment == null && other.idEnviroment != null) || (this.idEnviroment != null && !this.idEnviroment.equals(other.idEnviroment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Enviroment[ idEnviroment=" + idEnviroment + " ]";
    }
    
}

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
@Table(name = "color", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByIdColor", query = "SELECT c FROM Color c WHERE c.idColor = :idColor")
    , @NamedQuery(name = "Color.findByDenomination", query = "SELECT c FROM Color c WHERE c.denomination = :denomination")
    , @NamedQuery(name = "Color.findByCreatedAt", query = "SELECT c FROM Color c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Color.findByUpdatedAt", query = "SELECT c FROM Color c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Color.findByStatus", query = "SELECT c FROM Color c WHERE c.status = :status")
    , @NamedQuery(name = "Color.findByHex", query = "SELECT c FROM Color c WHERE c.hex = :hex")
    , @NamedQuery(name = "Color.findByClass1", query = "SELECT c FROM Color c WHERE c.class1 = :class1")
    , @NamedQuery(name = "Color.findByD", query = "SELECT c FROM Color c WHERE c.d = :d")
    , @NamedQuery(name = "Color.findByClassM", query = "SELECT c FROM Color c WHERE c.classM = :classM")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_color")
    private Integer idColor;
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
    @Column(name = "hex")
    private String hex;
    @Column(name = "class")
    private String class1;
    @Column(name = "d")
    private String d;
    @Column(name = "class_m")
    private String classM;
    
    @JsonIgnore
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idTaskColor")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColor")
    private Collection<Products> productsCollection;

    public Color() {
    }

    public Color(Integer idColor) {
        this.idColor = idColor;
    }

    public Color(Integer idColor, String denomination, short status) {
        this.idColor = idColor;
        this.denomination = denomination;
        this.status = status;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
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

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getClassM() {
        return classM;
    }

    public void setClassM(String classM) {
        this.classM = classM;
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
        hash += (idColor != null ? idColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Color[ idColor=" + idColor + " ]";
    }
    
}

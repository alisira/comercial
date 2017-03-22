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
@Table(name = "discount_user", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DiscountUser.findAll", query = "SELECT d FROM DiscountUser d")
    , @NamedQuery(name = "DiscountUser.findByIdDiscountUser", query = "SELECT d FROM DiscountUser d WHERE d.idDiscountUser = :idDiscountUser")
    , @NamedQuery(name = "DiscountUser.findByIdUser", query = "SELECT d FROM DiscountUser d WHERE d.idUser = :idUser")
    , @NamedQuery(name = "DiscountUser.findByStatus", query = "SELECT d FROM DiscountUser d WHERE d.status = :status")
    , @NamedQuery(name = "DiscountUser.findByCreatedAt", query = "SELECT d FROM DiscountUser d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "DiscountUser.findByUpdatedAt", query = "SELECT d FROM DiscountUser d WHERE d.updatedAt = :updatedAt")})
public class DiscountUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discount_user")
    private Integer idDiscountUser;
    @Basic(optional = false)
    @Column(name = "id_user")
    private long idUser;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_discount", referencedColumnName = "id_discount")
    @ManyToOne(optional = false)
    private Discount idDiscount;

    public DiscountUser() {
    }

    public DiscountUser(Integer idDiscountUser) {
        this.idDiscountUser = idDiscountUser;
    }

    public DiscountUser(Integer idDiscountUser, long idUser, short status) {
        this.idDiscountUser = idDiscountUser;
        this.idUser = idUser;
        this.status = status;
    }

    public Integer getIdDiscountUser() {
        return idDiscountUser;
    }

    public void setIdDiscountUser(Integer idDiscountUser) {
        this.idDiscountUser = idDiscountUser;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscountUser != null ? idDiscountUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountUser)) {
            return false;
        }
        DiscountUser other = (DiscountUser) object;
        if ((this.idDiscountUser == null && other.idDiscountUser != null) || (this.idDiscountUser != null && !this.idDiscountUser.equals(other.idDiscountUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.DiscountUser[ idDiscountUser=" + idDiscountUser + " ]";
    }
    
}

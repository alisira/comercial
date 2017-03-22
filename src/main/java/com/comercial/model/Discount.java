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
@Table(name = "discount", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d")
    , @NamedQuery(name = "Discount.findByIdDiscount", query = "SELECT d FROM Discount d WHERE d.idDiscount = :idDiscount")
    , @NamedQuery(name = "Discount.findByCode", query = "SELECT d FROM Discount d WHERE d.code = :code")
    , @NamedQuery(name = "Discount.findByDescription", query = "SELECT d FROM Discount d WHERE d.description = :description")
    , @NamedQuery(name = "Discount.findByDateInit", query = "SELECT d FROM Discount d WHERE d.dateInit = :dateInit")
    , @NamedQuery(name = "Discount.findByDateEnd", query = "SELECT d FROM Discount d WHERE d.dateEnd = :dateEnd")
    , @NamedQuery(name = "Discount.findByIdCalcuBase", query = "SELECT d FROM Discount d WHERE d.idCalcuBase = :idCalcuBase")
    , @NamedQuery(name = "Discount.findByAliquot", query = "SELECT d FROM Discount d WHERE d.aliquot = :aliquot")
    , @NamedQuery(name = "Discount.findByStatus", query = "SELECT d FROM Discount d WHERE d.status = :status")
    , @NamedQuery(name = "Discount.findByUseLimit", query = "SELECT d FROM Discount d WHERE d.useLimit = :useLimit")
    , @NamedQuery(name = "Discount.findByTypeUser", query = "SELECT d FROM Discount d WHERE d.typeUser = :typeUser")
    , @NamedQuery(name = "Discount.findByCreatedAt", query = "SELECT d FROM Discount d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "Discount.findByUpdatedAt", query = "SELECT d FROM Discount d WHERE d.updatedAt = :updatedAt")})
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discount")
    private Integer idDiscount;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "date_init")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInit;
    @Basic(optional = false)
    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Basic(optional = false)
    @Column(name = "id_calcu_base")
    private short idCalcuBase;
    @Basic(optional = false)
    @Column(name = "aliquot")
    private double aliquot;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @Column(name = "use_limit")
    private short useLimit;
    @Basic(optional = false)
    @Column(name = "type_user")
    private short typeUser;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiscount")
    private Collection<DiscountUser> discountUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiscount")
    private Collection<DiscountPurchase> discountPurchaseCollection;

    public Discount() {
    }

    public Discount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    public Discount(Integer idDiscount, String code, String description, Date dateInit, Date dateEnd, short idCalcuBase, double aliquot, short status, short useLimit, short typeUser) {
        this.idDiscount = idDiscount;
        this.code = code;
        this.description = description;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.idCalcuBase = idCalcuBase;
        this.aliquot = aliquot;
        this.status = status;
        this.useLimit = useLimit;
        this.typeUser = typeUser;
    }

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public short getIdCalcuBase() {
        return idCalcuBase;
    }

    public void setIdCalcuBase(short idCalcuBase) {
        this.idCalcuBase = idCalcuBase;
    }

    public double getAliquot() {
        return aliquot;
    }

    public void setAliquot(double aliquot) {
        this.aliquot = aliquot;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public short getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(short useLimit) {
        this.useLimit = useLimit;
    }

    public short getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(short typeUser) {
        this.typeUser = typeUser;
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

    public Collection<DiscountUser> getDiscountUserCollection() {
        return discountUserCollection;
    }

    public void setDiscountUserCollection(Collection<DiscountUser> discountUserCollection) {
        this.discountUserCollection = discountUserCollection;
    }

    public Collection<DiscountPurchase> getDiscountPurchaseCollection() {
        return discountPurchaseCollection;
    }

    public void setDiscountPurchaseCollection(Collection<DiscountPurchase> discountPurchaseCollection) {
        this.discountPurchaseCollection = discountPurchaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscount != null ? idDiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.idDiscount == null && other.idDiscount != null) || (this.idDiscount != null && !this.idDiscount.equals(other.idDiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Discount[ idDiscount=" + idDiscount + " ]";
    }
    
}

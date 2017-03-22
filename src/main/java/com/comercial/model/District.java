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
@Table(name = "district", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d")
    , @NamedQuery(name = "District.findByIdDistrict", query = "SELECT d FROM District d WHERE d.idDistrict = :idDistrict")
    , @NamedQuery(name = "District.findByDenomination", query = "SELECT d FROM District d WHERE d.denomination = :denomination")
    , @NamedQuery(name = "District.findByCreatedAt", query = "SELECT d FROM District d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "District.findByUpdatedAt", query = "SELECT d FROM District d WHERE d.updatedAt = :updatedAt")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_district")
    private Integer idDistrict;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "idDistrict")
    private Collection<ShipInfo> shipInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistrict")
    private Collection<Store> storeCollection;

    public District() {
    }

    public District(Integer idDistrict) {
        this.idDistrict = idDistrict;
    }

    public District(Integer idDistrict, String denomination) {
        this.idDistrict = idDistrict;
        this.denomination = denomination;
    }

    public Integer getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(Integer idDistrict) {
        this.idDistrict = idDistrict;
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

    public Collection<ShipInfo> getShipInfoCollection() {
        return shipInfoCollection;
    }

    public void setShipInfoCollection(Collection<ShipInfo> shipInfoCollection) {
        this.shipInfoCollection = shipInfoCollection;
    }

    public Collection<Store> getStoreCollection() {
        return storeCollection;
    }

    public void setStoreCollection(Collection<Store> storeCollection) {
        this.storeCollection = storeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistrict != null ? idDistrict.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.idDistrict == null && other.idDistrict != null) || (this.idDistrict != null && !this.idDistrict.equals(other.idDistrict))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.District[ idDistrict=" + idDistrict + " ]";
    }
    
}

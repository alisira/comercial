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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ship_info", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ShipInfo.findAll", query = "SELECT s FROM ShipInfo s")
    , @NamedQuery(name = "ShipInfo.findByIdShipInfo", query = "SELECT s FROM ShipInfo s WHERE s.idShipInfo = :idShipInfo")
    , @NamedQuery(name = "ShipInfo.findByDate", query = "SELECT s FROM ShipInfo s WHERE s.date = :date")
    , @NamedQuery(name = "ShipInfo.findByIdUser", query = "SELECT s FROM ShipInfo s WHERE s.idUser = :idUser")
    , @NamedQuery(name = "ShipInfo.findByCity", query = "SELECT s FROM ShipInfo s WHERE s.city = :city")
    , @NamedQuery(name = "ShipInfo.findByAddress", query = "SELECT s FROM ShipInfo s WHERE s.address = :address")
    , @NamedQuery(name = "ShipInfo.findByPostalCode", query = "SELECT s FROM ShipInfo s WHERE s.postalCode = :postalCode")
    , @NamedQuery(name = "ShipInfo.findByCreatedAt", query = "SELECT s FROM ShipInfo s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "ShipInfo.findByUpdatedAt", query = "SELECT s FROM ShipInfo s WHERE s.updatedAt = :updatedAt")
    , @NamedQuery(name = "ShipInfo.findByIdCountry", query = "SELECT s FROM ShipInfo s WHERE s.idCountry = :idCountry")})
public class ShipInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ship_info")
    private Integer idShipInfo;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "id_country")
    private Integer idCountry;
    @JoinColumn(name = "id_district", referencedColumnName = "id_district")
    @ManyToOne
    private District idDistrict;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idShipInfo")
    private Collection<Purchase> purchaseCollection;

    public ShipInfo() {
    }

    public ShipInfo(Integer idShipInfo) {
        this.idShipInfo = idShipInfo;
    }

    public ShipInfo(Integer idShipInfo, int idUser, String city, String address) {
        this.idShipInfo = idShipInfo;
        this.idUser = idUser;
        this.city = city;
        this.address = address;
    }

    public Integer getIdShipInfo() {
        return idShipInfo;
    }

    public void setIdShipInfo(Integer idShipInfo) {
        this.idShipInfo = idShipInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public District getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(District idDistrict) {
        this.idDistrict = idDistrict;
    }

    public Collection<Purchase> getPurchaseCollection() {
        return purchaseCollection;
    }

    public void setPurchaseCollection(Collection<Purchase> purchaseCollection) {
        this.purchaseCollection = purchaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShipInfo != null ? idShipInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipInfo)) {
            return false;
        }
        ShipInfo other = (ShipInfo) object;
        if ((this.idShipInfo == null && other.idShipInfo != null) || (this.idShipInfo != null && !this.idShipInfo.equals(other.idShipInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.ShipInfo[ idShipInfo=" + idShipInfo + " ]";
    }
    
}

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
@Table(name = "offer", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o")
    , @NamedQuery(name = "Offer.findByIdOffer", query = "SELECT o FROM Offer o WHERE o.idOffer = :idOffer")
    , @NamedQuery(name = "Offer.findByDenomination", query = "SELECT o FROM Offer o WHERE o.denomination = :denomination")
    , @NamedQuery(name = "Offer.findByDescription", query = "SELECT o FROM Offer o WHERE o.description = :description")
    , @NamedQuery(name = "Offer.findByDateInit", query = "SELECT o FROM Offer o WHERE o.dateInit = :dateInit")
    , @NamedQuery(name = "Offer.findByDateEnd", query = "SELECT o FROM Offer o WHERE o.dateEnd = :dateEnd")
    , @NamedQuery(name = "Offer.findByIdCalcuBase", query = "SELECT o FROM Offer o WHERE o.idCalcuBase = :idCalcuBase")
    , @NamedQuery(name = "Offer.findByAliquot", query = "SELECT o FROM Offer o WHERE o.aliquot = :aliquot")
    , @NamedQuery(name = "Offer.findByStatus", query = "SELECT o FROM Offer o WHERE o.status = :status")
    , @NamedQuery(name = "Offer.findByCreatedAt", query = "SELECT o FROM Offer o WHERE o.createdAt = :createdAt")
    , @NamedQuery(name = "Offer.findByUpdatedAt", query = "SELECT o FROM Offer o WHERE o.updatedAt = :updatedAt")})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_offer")
    private Integer idOffer;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
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
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Offer() {
    }

    public Offer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public Offer(Integer idOffer, String denomination, String description, Date dateInit, Date dateEnd, short idCalcuBase, double aliquot, short status) {
        this.idOffer = idOffer;
        this.denomination = denomination;
        this.description = description;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.idCalcuBase = idCalcuBase;
        this.aliquot = aliquot;
        this.status = status;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffer != null ? idOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.idOffer == null && other.idOffer != null) || (this.idOffer != null && !this.idOffer.equals(other.idOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Offer[ idOffer=" + idOffer + " ]";
    }
    
}

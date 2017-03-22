/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author asira
 */
@Entity
@Table(name = "rank", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r")
    , @NamedQuery(name = "Rank.findByIdRank", query = "SELECT r FROM Rank r WHERE r.idRank = :idRank")
    , @NamedQuery(name = "Rank.findByDenomination", query = "SELECT r FROM Rank r WHERE r.denomination = :denomination")
    , @NamedQuery(name = "Rank.findByStatus", query = "SELECT r FROM Rank r WHERE r.status = :status")})
public class Rank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rank")
    private Integer idRank;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;

    public Rank() {
    }

    public Rank(Integer idRank) {
        this.idRank = idRank;
    }

    public Rank(Integer idRank, String denomination, short status) {
        this.idRank = idRank;
        this.denomination = denomination;
        this.status = status;
    }

    public Integer getIdRank() {
        return idRank;
    }

    public void setIdRank(Integer idRank) {
        this.idRank = idRank;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRank != null ? idRank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rank)) {
            return false;
        }
        Rank other = (Rank) object;
        if ((this.idRank == null && other.idRank != null) || (this.idRank != null && !this.idRank.equals(other.idRank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Rank[ idRank=" + idRank + " ]";
    }
    
}

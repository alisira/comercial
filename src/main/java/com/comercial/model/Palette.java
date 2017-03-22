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
@Table(name = "palette", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Palette.findAll", query = "SELECT p FROM Palette p")
    , @NamedQuery(name = "Palette.findByIdPalette", query = "SELECT p FROM Palette p WHERE p.idPalette = :idPalette")
    , @NamedQuery(name = "Palette.findByDenomination", query = "SELECT p FROM Palette p WHERE p.denomination = :denomination")
    , @NamedQuery(name = "Palette.findByStatus", query = "SELECT p FROM Palette p WHERE p.status = :status")})
public class Palette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palette")
    private Integer idPalette;
    @Basic(optional = false)
    @Column(name = "denomination")
    private String denomination;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;

    public Palette() {
    }

    public Palette(Integer idPalette) {
        this.idPalette = idPalette;
    }

    public Palette(Integer idPalette, String denomination, short status) {
        this.idPalette = idPalette;
        this.denomination = denomination;
        this.status = status;
    }

    public Integer getIdPalette() {
        return idPalette;
    }

    public void setIdPalette(Integer idPalette) {
        this.idPalette = idPalette;
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
        hash += (idPalette != null ? idPalette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palette)) {
            return false;
        }
        Palette other = (Palette) object;
        if ((this.idPalette == null && other.idPalette != null) || (this.idPalette != null && !this.idPalette.equals(other.idPalette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Palette[ idPalette=" + idPalette + " ]";
    }
    
}

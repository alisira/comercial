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
@Table(name = "ipn", catalog = "comercial", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Ipn.findAll", query = "SELECT i FROM Ipn i")
    , @NamedQuery(name = "Ipn.findByIdIpn", query = "SELECT i FROM Ipn i WHERE i.idIpn = :idIpn")
    , @NamedQuery(name = "Ipn.findByValor", query = "SELECT i FROM Ipn i WHERE i.valor = :valor")
    , @NamedQuery(name = "Ipn.findByFecha", query = "SELECT i FROM Ipn i WHERE i.fecha = :fecha")})
public class Ipn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ipn")
    private Integer idIpn;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Ipn() {
    }

    public Ipn(Integer idIpn) {
        this.idIpn = idIpn;
    }

    public Ipn(Integer idIpn, String valor) {
        this.idIpn = idIpn;
        this.valor = valor;
    }

    public Integer getIdIpn() {
        return idIpn;
    }

    public void setIdIpn(Integer idIpn) {
        this.idIpn = idIpn;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIpn != null ? idIpn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ipn)) {
            return false;
        }
        Ipn other = (Ipn) object;
        if ((this.idIpn == null && other.idIpn != null) || (this.idIpn != null && !this.idIpn.equals(other.idIpn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Ipn[ idIpn=" + idIpn + " ]";
    }
    
}

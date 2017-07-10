/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.dto;

import java.io.Serializable;

public class StatusDto implements Serializable {

    private static final long serialVersionUID = 1L;    
    
    private Integer idStatus;    
    private String denomination;    
    private String table; 

    public StatusDto() {
    }

    public StatusDto(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public StatusDto(Integer idStatus, String denomination, String table) {
        this.idStatus = idStatus;
        this.denomination = denomination;
        this.table = table;
    }

    public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusDto)) {
            return false;
        }
        StatusDto other = (StatusDto) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comercial.model.Status[ idStatus=" + idStatus + " ]";
    }
    
}

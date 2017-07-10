/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ali Sira
 */

public final class ColorDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idColor;
    
    @Size(max = 500)
    private String denomination;
    
    @NotEmpty
    private short idStatus;
    
    private String hex;
    
    private String class1;
    
    private String d;
    
    private String classM;
    
    private Date createdAt;
    
    private Date updatedAt;
    

    public ColorDto() {
    }

    public Long getIdColor() {
		return idColor;
	}

	public void setIdColor(Long idColor) {
		this.idColor = idColor;
	}

	public String getDenomination() {
		return denomination;
	}



	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}




	public short getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(short idStatus) {
		this.idStatus = idStatus;
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



	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idColor != null ? idColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorDto)) {
            return false;
        }
        ColorDto other = (ColorDto) object;
        if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("denomination", this.denomination)
                .append("idStatus", this.idStatus)
                .append("hex", this.hex)
                .append("class1", this.class1)
                .append("d", this.d)
                .append("classM", this.classM)                
                .toString();
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
    
}

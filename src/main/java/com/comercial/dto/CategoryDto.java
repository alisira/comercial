/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ali Sira
 */

public final class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    private Long idCategory;
    
    @Size(max = 500)
    private String denomination;
    
    private short idStatus;
    
    private Date createdAt;
    
    private Date updatedAt;    

    public CategoryDto() {
    }

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
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

package com.comercial.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.Entity;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
    @Transient
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return (attribute == null ? null : Timestamp.valueOf(attribute));
	}

	@Override
    @Transient
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return (dbData == null ? null : dbData.toLocalDateTime());
	}




}

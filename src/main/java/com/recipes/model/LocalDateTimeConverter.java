package com.recipes.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {
 
    @Override
    public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime attribute) {
        return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
    }
 
    @Override
    public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData) {
        return dbData == null ? null : dbData.toLocalDateTime();
    }
}

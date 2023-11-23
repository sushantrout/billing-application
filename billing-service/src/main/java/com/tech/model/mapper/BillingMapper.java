package com.tech.model.mapper;

public interface BillingMapper <DTO, ENTITY>{
    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
}

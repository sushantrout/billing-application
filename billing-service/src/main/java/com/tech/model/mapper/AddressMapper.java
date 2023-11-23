package com.tech.model.mapper;

import com.tech.model.dto.AddressDTO;
import com.tech.model.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements BillingMapper<AddressDTO, Address> {
    @Override
    public AddressDTO toDTO(com.tech.model.entity.Address entity) {
        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZip(entity.getZip());
        return dto;
    }

    @Override
    public Address toEntity(AddressDTO dto) {
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZip(dto.getZip());
        return entity;
    }
}

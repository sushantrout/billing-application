package com.tech.model.mapper;

import com.tech.model.dto.BillingUserDTO;
import com.tech.model.entity.BillingUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BillingUserMapper implements BillingMapper<BillingUserDTO, BillingUser> {
    private final AddressMapper addressMapper;
    @Override
    public BillingUserDTO toDTO(BillingUser entity) {
        BillingUserDTO dto = new BillingUserDTO();
        dto.setId(entity.getId());
        dto.setAddress(addressMapper.toDTO(entity.getAddress()));
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public BillingUser toEntity(BillingUserDTO dto) {
        BillingUser entity = new BillingUser();
        entity.setId(dto.getId());
        entity.setAddress(addressMapper.toEntity(dto.getAddress()));
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}

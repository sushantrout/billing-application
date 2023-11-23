package com.tech.service;

import com.tech.model.dto.AddressDTO;
import com.tech.model.entity.Address;
import com.tech.model.mapper.AddressMapper;
import com.tech.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDTO(address);
    }

    public AddressDTO getAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        return addressMapper.toDTO(address);
    }

    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(addressMapper::toDTO).toList();
    }

    public AddressDTO deleteAddress(Long id) {
        return addressRepository.findById(id).map(address -> {
            addressRepository.delete(address);
            return addressMapper.toDTO(address);
        }).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public AddressDTO updateAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDTO(address);
    }
}

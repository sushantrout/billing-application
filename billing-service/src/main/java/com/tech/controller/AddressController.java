package com.tech.controller;

import com.tech.model.dto.AddressDTO;
import com.tech.model.dto.ResponseDTO;
import com.tech.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    @GetMapping("/{id}")
    public AddressDTO getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @GetMapping
    public ResponseDTO findAll() {
        List<AddressDTO> all = addressService.findAll();
        return ResponseDTO.<AddressDTO>builder()
                .dataList(all)
                .build();
    }

    @DeleteMapping("/{id}")
    public AddressDTO deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }

    @PutMapping
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        return addressService.updateAddress(addressDTO);
    }
}

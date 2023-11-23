package com.tech.service;

import com.tech.model.dto.BillingUserDTO;
import com.tech.model.dto.ResponseDTO;
import com.tech.model.entity.BillingUser;
import com.tech.model.mapper.BillingUserMapper;
import com.tech.repository.BillingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingUserService {
    private final BillingUserRepository billingUserRepository;
    private final BillingUserMapper billingUserMapper;
    public BillingUserDTO createBillingUser(BillingUserDTO billingUserDTO) {
        BillingUser save = billingUserRepository.save(billingUserMapper.toEntity(billingUserDTO));
        return billingUserMapper.toDTO(save);
    }

    public BillingUserDTO getBillingUser(Long id) {
        BillingUser billingUser = billingUserRepository.findById(id).orElseThrow(() -> new RuntimeException("BillingUser not found"));
        return billingUserMapper.toDTO(billingUser);
    }

    public ResponseDTO findAll() {
        List<BillingUserDTO> billingUserDTOS = billingUserRepository.findAll().stream().map(billingUserMapper::toDTO).toList();
        return ResponseDTO.<BillingUserDTO>builder()
                .dataList(billingUserDTOS)
                .build();
    }

    public BillingUserDTO deleteBillingUser(Long id) {
        return billingUserRepository.findById(id).map(billingUser -> {
            billingUserRepository.delete(billingUser);
            return billingUserMapper.toDTO(billingUser);
        }).orElseThrow(() -> new RuntimeException("BillingUser not found"));
    }

    public BillingUserDTO updateBillingUser(BillingUserDTO billingUserDTO) {
        BillingUser billingUser = billingUserMapper.toEntity(billingUserDTO);
        billingUser = billingUserRepository.save(billingUser);
        return billingUserMapper.toDTO(billingUser);
    }
}

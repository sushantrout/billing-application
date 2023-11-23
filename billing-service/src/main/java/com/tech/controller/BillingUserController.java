package com.tech.controller;

import com.tech.model.dto.BillingUserDTO;
import com.tech.model.dto.ResponseDTO;
import com.tech.service.BillingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing-user")
@RequiredArgsConstructor
public class BillingUserController {
    private final BillingUserService billingUserService;

    @PostMapping
    public BillingUserDTO createBillingUser(@RequestBody BillingUserDTO billingUserDTO){
        return billingUserService.createBillingUser(billingUserDTO);
    }

    @GetMapping("/{id}")
    public BillingUserDTO getBillingUser(@PathVariable Long id) {
        return billingUserService.getBillingUser(id);
    }

    @GetMapping
    public ResponseDTO findAll() {
        return billingUserService.findAll();
    }

    @DeleteMapping("/{id}")
    public BillingUserDTO deleteBillingUser(@PathVariable Long id) {
        return billingUserService.deleteBillingUser(id);
    }

    @PutMapping
    public BillingUserDTO updateBillingUser(@RequestBody BillingUserDTO billingUserDTO) {
        return billingUserService.updateBillingUser(billingUserDTO);
    }

}

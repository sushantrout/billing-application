package com.tech.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AddressListener {
    @PrePersist
    public void onPrePersist(Object object) {
        System.out.println("PrePersist");
    }

    @PreUpdate
    public void onPreUpdate(Object object) {
        System.out.println("PreUpdate");
    }
}

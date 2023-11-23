package com.tech.model.entity;

import com.tech.listener.AddressListener;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.event.EventListener;

@Entity
@Table(name = "tbl_address")
@Data
@EntityListeners(AddressListener.class)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zip;

    @PrePersist
    public void prePersist() {
        System.out.println("PrePersist");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("PreUpdate");
    }
}

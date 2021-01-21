package com.example.test.demo.Entity;

import com.example.test.demo.DTO.StoreDTO;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String owner;
    private String description;
    private long level;
    private String address;
    private String phone;
    private String[] holidays;

    @ManyToMany
    @JoinColumn(name = "BusinessTimes_id",nullable = false)
    private List<BusinessTimes> businessTimes;



    public Store(StoreDTO storeDTO) {
        this.id = storeDTO.getId();
        this.name = storeDTO.getName();
        this.owner = storeDTO.getOwner();
        this.description = storeDTO.getDescription();
        this.level = storeDTO.getLevel();
        this.address = storeDTO.getAddress();
        this.phone = storeDTO.getPhone();
        this.holidays = storeDTO.getHolidays();
        this.businessTimes=storeDTO.getBusinessTimes();
    }

    public Store() {
    }
}

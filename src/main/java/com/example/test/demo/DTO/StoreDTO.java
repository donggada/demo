package com.example.test.demo.DTO;

import com.example.test.demo.Entity.BusinessTimes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StoreDTO {
    private long id;
    private String name;
    private String owner;
    private String description;
    private long level;
    private String address;
    private String phone;
    private String[] holidays;
    private List<BusinessTimes> businessTimes;
}

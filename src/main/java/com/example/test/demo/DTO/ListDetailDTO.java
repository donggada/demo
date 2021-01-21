package com.example.test.demo.DTO;

import com.example.test.demo.Entity.BusinessTimes;
import com.example.test.demo.Entity.Store;
import lombok.Data;

import java.util.List;
@Data
public class ListDetailDTO {
    private long id;
    private String name;
    private String description;
    private long level;
    private String address;
    private String phone;
    private List<BusinessDaysDTO> businessDays;

    public ListDetailDTO(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.description = store.getDescription();
        this.level = store.getLevel();
        this.address = store.getAddress();
        this.phone = store.getPhone();
    }

    public ListDetailDTO() {
    }
}

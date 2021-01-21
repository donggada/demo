package com.example.test.demo.DTO;

import com.example.test.demo.Entity.BusinessTimes;
import lombok.Data;

import java.util.List;
@Data
public class ListDTO {
    private String name;
    private String description;
    private Long level;
    private String businessStatus;

}

package com.example.test.demo.Entity;

import com.example.test.demo.DTO.BusinessTimesDTO;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class BusinessTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String day;
    private String open;
    private String close;

    public BusinessTimes(String day, String open, String close) {
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public BusinessTimes() {

    }
    public BusinessTimes(BusinessTimesDTO businessTimesDTO) {
        this.day = businessTimesDTO.getDay();
        this.open = businessTimesDTO.getOpen();
        this.close = businessTimesDTO.getDay();
    }

}

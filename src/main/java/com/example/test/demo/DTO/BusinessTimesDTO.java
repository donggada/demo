package com.example.test.demo.DTO;

import lombok.Data;

@Data
public class BusinessTimesDTO {

    private long id;
    private String day;
    private String open;
    private String close;

    public BusinessTimesDTO(String day, String open, String close) {
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public BusinessTimesDTO() {
    }
}

package com.example.sail_it_portal.dto;

import lombok.Data;
import java.util.Date;

@Data
public class AssetsDTO {

    private String name;
    private Date purchaseDate;

    private String status;
    private Integer userId;
}

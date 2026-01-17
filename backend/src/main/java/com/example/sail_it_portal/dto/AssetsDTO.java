package com.example.sail_it_portal.dto;

import com.example.sail_it_portal.model.AssetStatus;
import lombok.Data;
import java.util.Date;

@Data
public class AssetsDTO {
    private String name;
    private Date purchaseDate;
    private AssetStatus status;
    private Integer userId;
    private Integer categoryId;

}

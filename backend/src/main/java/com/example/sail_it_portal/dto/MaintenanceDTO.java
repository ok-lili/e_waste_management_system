package com.example.sail_it_portal.dto;

import lombok.Data;
import java.util.Date;

@Data
public class MaintenanceDTO {
    private Date lastMaintenanceDate;
    private Date nextMaintenanceDate;
    private String remarks;
    private Integer assetId;

}

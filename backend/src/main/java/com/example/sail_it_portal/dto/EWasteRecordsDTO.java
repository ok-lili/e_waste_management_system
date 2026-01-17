package com.example.sail_it_portal.dto;

import lombok.Data;
import java.util.Date;

@Data
public class EWasteRecordsDTO {
    private Date disposalDate;
    private String disposalMethod;
    private String remarks;
    private String recyclerName;
    private Integer assetId;
}

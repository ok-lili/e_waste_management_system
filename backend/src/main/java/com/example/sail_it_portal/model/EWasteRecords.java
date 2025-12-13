package com.example.sail_it_portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="e_waste_records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EWasteRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_waste_id;
    private int asset_id;
    private Date disposal_date;
    private String disposal_method;
    private String remakrds;
    private String recycler_name;
}

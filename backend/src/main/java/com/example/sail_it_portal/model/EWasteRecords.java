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
    @Column(name="asset_id")
    private int asset_id;
    @Column(name = "disposal_date")
    private Date disposal_date;
    @Column(name = "disposal_method")
    private String disposal_method;
    @Column(name = "remarks")
    private String remakrds;
    @Column(name = "recycler_name")
    private String recycler_name;
}

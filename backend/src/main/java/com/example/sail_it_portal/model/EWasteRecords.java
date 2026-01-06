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
    @Column(name = "e_waste_id")
    private int eWasteId; // Changed from e_waste_id

    @Column(name = "asset_id")
    private int assetId; // Changed from asset_id

    @Column(name = "disposal_date")
    private Date disposalDate; // Changed from disposal_date

    @Column(name = "disposal_method")
    private String disposalMethod;

    @Column(name = "remarks")
    private String remarks; // Fixed spelling from remakrds

    @Column(name = "recycler_name")
    private String recyclerName; // Changed from recycler_name
}
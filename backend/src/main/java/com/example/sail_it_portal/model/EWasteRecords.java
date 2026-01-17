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
    private int eWasteId;
    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "asset_id", nullable = false)
    private Assets asset;
    @Column(name = "disposal_date")
    private Date disposalDate;
    @Column(name = "disposal_method")
    private String disposalMethod;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "recycler_name")
    private String recyclerName;
}

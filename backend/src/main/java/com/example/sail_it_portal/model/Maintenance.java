package com.example.sail_it_portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name="maintenance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maintenance_id")
    private int maintenanceId;
    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false , referencedColumnName = "asset_id")
    private Assets asset;
    @Column(name="last_maintenance_date")
    private Date lastMaintenanceDate;
    @Column(name="next_maintenance_date")
    private Date nextMaintenanceDate;
    @Column(name="remarks")
    private String remarks;
}

package com.example.sail_it_portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int asset_id;
    @Column(name="asset_name")
    private String assetName;
    @Column(name="purchase_date")
    private Date purchaseDate;
    @Column(name="status")
    private String status;
    @Column(name="user_id")
    private int userId;
}

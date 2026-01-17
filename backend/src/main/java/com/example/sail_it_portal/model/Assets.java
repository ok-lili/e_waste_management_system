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
    @Column(name = "asset_id")
    private int assetId;
    @Column(name="asset_name")
    private String assetName;
    @Column(name="purchase_date")
    private Date purchaseDate;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private AssetStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private AssetCategories category;
    public boolean isEwaste() {
        return this.status == AssetStatus.DAMAGED;
    }

    public void markAsEwaste() {
        this.status = AssetStatus.DAMAGED;
    }

    public void markActive() {
        this.status = AssetStatus.ACTIVE;
    }
}

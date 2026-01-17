package com.example.sail_it_portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="asset_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name="category_name", unique = true, nullable = false)
    private String categoryName;
    @OneToMany(mappedBy = "category") //not categoryId bcz it's not the field name in Assets,it's a DB column
    private List<Assets> assets;
    @Column(name = "is_active")
    private Boolean isActive = true; // used for soft deletes/deactivation , instead of deleting a record from the database (hard delete), you mark it inactive.
//learn few points about adv and disadv for soft deleting
}

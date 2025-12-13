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
    private String asset_name;
    private Date purchase_date;
    private String status;
    private int user_id;
}

package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.Maintenance; // Maintenance entity import karein
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Integer> {
    // Ab ye 'Maintenance' entity mein 'assetId' dhoondega
    List<Maintenance> findByAssetId(Integer assetId);
}
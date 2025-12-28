package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.Maintenance;
import com.example.sail_it_portal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<Users,Integer> {
    List<Maintenance> findByLastMaintenanceDate(Date lastMaintenanceDate);
    List<Maintenance> findByNextMaintenanceDate(Date nextMaintenanceDate);
    public Maintenance findByAssetId(Integer assetId);

}

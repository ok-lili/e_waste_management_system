package com.example.sail_it_portal.service;

import com.example.sail_it_portal.dto.MaintenanceDTO;
import com.example.sail_it_portal.model.Assets;
import com.example.sail_it_portal.model.Maintenance;
import com.example.sail_it_portal.repository.AssetsRepo;
import com.example.sail_it_portal.repository.MaintenanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private AssetsRepo assetsRepo;

    @Autowired
    private MaintenanceRepo maintenanceRepo;

    public Maintenance addMaintenance(Integer assetId, MaintenanceDTO dto) {
        Assets asset = assetsRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
        if (asset.isEwaste()) {
            throw new RuntimeException("Cannot add maintenance for E-Waste asset");
        }
        Maintenance maintenance = new Maintenance();
        maintenance.setAsset(asset);
        maintenance.setLastMaintenanceDate(dto.getLastMaintenanceDate());
        maintenance.setNextMaintenanceDate(dto.getNextMaintenanceDate());
        maintenance.setRemarks(dto.getRemarks());

        return maintenanceRepo.save(maintenance);
    }

    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepo.findAll();
    }
}

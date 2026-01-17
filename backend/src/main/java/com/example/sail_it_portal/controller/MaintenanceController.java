package com.example.sail_it_portal.controller;

import com.example.sail_it_portal.dto.MaintenanceDTO;
import com.example.sail_it_portal.model.Maintenance;
import com.example.sail_it_portal.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/assets")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/{assetId}/maintenance")
    public ResponseEntity<Maintenance> addMaintenance (
            @PathVariable Integer assetId,
            @RequestBody MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = maintenanceService.addMaintenance(assetId, maintenanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenance);
    }

    @GetMapping( "/maintenance")
    public ResponseEntity<List<Maintenance>> getAllMaintenance() {
        return ResponseEntity.ok(maintenanceService.getAllMaintenance());
    }
}

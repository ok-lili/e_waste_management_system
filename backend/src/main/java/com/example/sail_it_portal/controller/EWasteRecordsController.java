package com.example.sail_it_portal.controller;

import com.example.sail_it_portal.dto.EWasteRecordsDTO;
import com.example.sail_it_portal.model.EWasteRecords;
import com.example.sail_it_portal.service.EWasteRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class EWasteRecordsController {

    @Autowired
    private EWasteRecordsService ewasteRecordsService;

    @PostMapping("/{assetId}/ewaste")
    public ResponseEntity<EWasteRecords> markAsEWaste(
            @PathVariable Integer assetId,
            @RequestBody EWasteRecordsDTO ewasteDTO) {

        EWasteRecords ewaste = ewasteRecordsService.createEWaste(assetId, ewasteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ewaste);
    }

    @GetMapping("/ewaste")
    public ResponseEntity<List<EWasteRecords>> getAllEWaste() {
        return ResponseEntity.ok(ewasteRecordsService.getAllEWaste());
    }
}

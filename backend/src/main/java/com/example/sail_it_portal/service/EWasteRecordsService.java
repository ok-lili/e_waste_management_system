package com.example.sail_it_portal.service;

import com.example.sail_it_portal.dto.EWasteRecordsDTO;
import com.example.sail_it_portal.model.Assets;
import com.example.sail_it_portal.model.EWasteRecords;
import com.example.sail_it_portal.repository.AssetsRepo;
import com.example.sail_it_portal.repository.EWasteRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EWasteRecordsService {

    @Autowired
    private AssetsRepo assetsRepo;

    @Autowired
    private EWasteRecordsRepo ewasteRecordsRepo;

    public EWasteRecords createEWaste(Integer assetId, EWasteRecordsDTO dto) {
        Assets asset = assetsRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        if (asset.isEwaste()) {
            throw new RuntimeException("Asset already marked as E-Waste");
        }
        EWasteRecords ewaste = new EWasteRecords();
        ewaste.setAsset(asset);
        ewaste.setDisposalDate(dto.getDisposalDate());
        ewaste.setDisposalMethod(dto.getDisposalMethod());
        ewaste.setRemarks(dto.getRemarks());
        ewaste.setRecyclerName(dto.getRecyclerName());

        asset.markAsEwaste();
        assetsRepo.save(asset);

        return ewasteRecordsRepo.save(ewaste);
    }
    public List<EWasteRecords> getAllEWaste() {
        return ewasteRecordsRepo.findAll();
    }
}

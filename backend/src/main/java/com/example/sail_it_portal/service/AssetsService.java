package com.example.sail_it_portal.service;

import com.example.sail_it_portal.dto.AssetsDTO;
import com.example.sail_it_portal.model.Assets;
import com.example.sail_it_portal.model.Users;
import com.example.sail_it_portal.repository.AssetsRepo;
import com.example.sail_it_portal.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsService {

    @Autowired
    private AssetsRepo assetsRepo;

    @Autowired
    private UsersRepo usersRepo;

    // Add new asset
    public Assets addAsset(AssetsDTO dto) {
        Assets asset = mapToEntity(dto);
        return assetsRepo.save(asset);
    }

    // Map DTO to Entity
    private Assets mapToEntity(AssetsDTO dto) {
        Assets asset = new Assets();
        asset.setAssetName(dto.getName());
        asset.setPurchaseDate(dto.getPurchaseDate());
        asset.setStatus(dto.getStatus());

        // ✅ Map userId to Users object
        Users user = usersRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        asset.setUser(user);

        return asset;
    }

    // Update existing asset
    public Assets updateAsset(Integer assetId, AssetsDTO dto) {
        Assets asset = assetsRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setAssetName(dto.getName());
        asset.setPurchaseDate(dto.getPurchaseDate());
        asset.setStatus(dto.getStatus());

        // ✅ Update user
        Users user = usersRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        asset.setUser(user);

        return assetsRepo.save(asset);
    }

    // Get all assets
    public List<Assets> getAllAssets() {
        return assetsRepo.findAll();
    }

    // Get asset by ID
    public Assets getAssetById(Integer assetId) {
        return assetsRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }
}

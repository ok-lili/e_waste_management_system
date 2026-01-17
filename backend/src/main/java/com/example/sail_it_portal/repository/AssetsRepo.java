package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.AssetStatus;
import com.example.sail_it_portal.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetsRepo extends JpaRepository<Assets,Integer> {
     Assets findByAssetName(String assetName);
    List<Assets> findByStatus(AssetStatus status);

}

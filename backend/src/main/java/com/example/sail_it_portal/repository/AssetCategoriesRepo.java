package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.AssetCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetCategoriesRepo
        extends JpaRepository<AssetCategories, Integer> {
    List<AssetCategories> findByIsActiveTrue();

}

package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.AssetCategories;
import com.example.sail_it_portal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsCategoriesRepo extends JpaRepository<AssetCategories,Integer> {
    public AssetCategories findByCategoryName(String categoryName);
}

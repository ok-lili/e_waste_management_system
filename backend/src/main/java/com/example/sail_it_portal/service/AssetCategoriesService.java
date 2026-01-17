package com.example.sail_it_portal.service;

import com.example.sail_it_portal.dto.AssetCategoriesDTO;
import com.example.sail_it_portal.model.AssetCategories;
import com.example.sail_it_portal.repository.AssetCategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetCategoriesService {
    @Autowired
    private AssetCategoriesRepo assetCategoriesRepo;
    public AssetCategories addCategory(AssetCategoriesDTO assetCategoriesDTO) {
        AssetCategories assetCategories = mapToEntity(assetCategoriesDTO);
        return assetCategoriesRepo.save(assetCategories);
    }
        private AssetCategories mapToEntity(AssetCategoriesDTO assetCategoriesDTO ) {
        AssetCategories assetCategories = new AssetCategories();
        assetCategories.setCategoryName(assetCategoriesDTO.getCategoryName());

        return assetCategories;
        }
        public List<AssetCategories> getAllCategory(){
        return  assetCategoriesRepo.findAll();
        }
    public AssetCategories getCategoryById(Integer categoryId) {
        return assetCategoriesRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public AssetCategories updateCategory(Integer categoryId, AssetCategoriesDTO dto) {
        AssetCategories category = assetCategoriesRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setCategoryName(dto.getCategoryName());

        return assetCategoriesRepo.save(category);
    }
    public void deleteCategory(Integer categoryId) {
        AssetCategories category = assetCategoriesRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        assetCategoriesRepo.delete(category);
    }


}

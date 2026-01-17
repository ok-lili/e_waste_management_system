package com.example.sail_it_portal.controller;

import com.example.sail_it_portal.dto.AssetCategoriesDTO;
import com.example.sail_it_portal.model.AssetCategories;
import com.example.sail_it_portal.service.AssetCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/assetCategories")
@CrossOrigin(origins ="*" )
public class AssetCategoriesController {
    @Autowired
    private AssetCategoriesService assetCategoriesService;
    @PostMapping
    public ResponseEntity<AssetCategories> addCategory(@RequestBody AssetCategoriesDTO assetCategoriesDTO) {
        AssetCategories savedAssetCategories = assetCategoriesService.addCategory(assetCategoriesDTO);
        return new ResponseEntity<>(savedAssetCategories, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AssetCategories>> getAllCategory() {
        return ResponseEntity.ok(assetCategoriesService.getAllCategory());
    }
    @GetMapping("{categoryId}")
    public ResponseEntity<AssetCategories> getCategoryById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(assetCategoriesService.getCategoryById(categoryId));
    }
    @PutMapping("{categoryId}")
    public ResponseEntity<AssetCategories> updateCategory(
            @PathVariable Integer categoryId,
            @RequestBody AssetCategoriesDTO dto
    ) {
        AssetCategories updatedCategory =
                assetCategoriesService.updateCategory(categoryId, dto);
        return ResponseEntity.ok(updatedCategory);
    }
    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId) {
        assetCategoriesService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }

}

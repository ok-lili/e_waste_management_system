package com.example.sail_it_portal.dto;

import jakarta.validation.constraints.NotBlank;

public class AssetCategoriesDTO {

    @NotBlank(message = "category name is required")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}

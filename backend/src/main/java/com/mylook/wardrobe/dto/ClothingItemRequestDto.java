package com.mylook.wardrobe.dto;

import com.mylook.wardrobe.model.ClothingCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClothingItemRequestDto(
        @NotBlank String name,
        @Size(max = 1200) String description,
        @NotNull ClothingCategory category,
        @NotBlank String color,
        String brand,
        String imageUrl
) {
}

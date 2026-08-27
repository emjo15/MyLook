package com.mylook.wardrobe.dto;

import com.mylook.wardrobe.model.ClothingCategory;

import java.time.Instant;

public record ClothingItemResponseDto(
        Long id,
        String name,
        String description,
        ClothingCategory category,
        String color,
        String brand,
        String imageUrl,
        Instant createdAt
) {
}

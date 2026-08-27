package com.mylook.wardrobe.service;

import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;

import java.util.List;

/**
 * Service contract for wardrobe clothing item operations.
 */
public interface ClothingItemService {

    /**
     * Returns all clothing items.
     */
    List<ClothingItemResponseDto> getAll();

    /**
     * Returns one clothing item by id.
     */
    ClothingItemResponseDto getById(Long id);

    /**
     * Creates a clothing item.
     */
    ClothingItemResponseDto create(ClothingItemRequestDto request);

    /**
     * Updates an existing clothing item.
     */
    ClothingItemResponseDto update(Long id, ClothingItemRequestDto request);

    /**
     * Deletes a clothing item by id.
     */
    void delete(Long id);
}

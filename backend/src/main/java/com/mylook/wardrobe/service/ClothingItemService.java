package com.mylook.wardrobe.service;

import com.mylook.wardrobe.dto.ClothingItemRequestDto;
import com.mylook.wardrobe.dto.ClothingItemResponseDto;

import java.util.List;

public interface ClothingItemService {

    List<ClothingItemResponseDto> getAll();

    ClothingItemResponseDto getById(Long id);

    ClothingItemResponseDto create(ClothingItemRequestDto request);

    ClothingItemResponseDto update(Long id, ClothingItemRequestDto request);

    void delete(Long id);
}
